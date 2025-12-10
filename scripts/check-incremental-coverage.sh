#!/bin/bash

# Скрипт для проверки покрытия измененных файлов

set -e

echo "=== Incremental Coverage Check ==="

# Определяем базовую ветку
if [ -n "$PR_BASE_REF" ]; then
    BASE_REF="origin/$PR_BASE_REF"
elif [ -n "$GITHUB_BASE_REF" ]; then
    BASE_REF="origin/$GITHUB_BASE_REF"
else
    BASE_REF="origin/main"
fi

echo "Base branch: $BASE_REF"
echo "Current branch: $(git rev-parse --abbrev-ref HEAD)"

# Получаем список измененных Java файлов
echo -e "\n=== Changed Java files ==="
CHANGED_FILES=$(git diff --name-only $BASE_REF HEAD | grep '\.java$' || true)

if [ -z "$CHANGED_FILES" ]; then
    echo "No Java files changed"
    exit 0
fi

echo "$CHANGED_FILES"

# Запускаем тесты для всех файлов
echo -e "\n=== Running tests ==="
mvn test jacoco:report -B

# Извлекаем общий процент покрытия
echo -e "\n=== Coverage Report ==="
COVERAGE=$(grep -oP 'line-coverage="\K[^"]+' target/site/jacoco/jacoco.xml | head -1 || echo "0")
echo "Total line coverage: ${COVERAGE}%"

# Проверяем минимальный порог
MIN_COVERAGE=50
if (( $(echo "$COVERAGE < $MIN_COVERAGE" | bc -l) )); then
    echo "❌ Coverage is below minimum threshold of ${MIN_COVERAGE}%"
    exit 1
else
    echo "✅ Coverage meets minimum threshold of ${MIN_COVERAGE}%"
fi

echo -e "\n=== Detailed coverage for changed files ==="
for file in $CHANGED_FILES; do
    # Конвертируем путь к исходникам в путь к классам
    CLASS_FILE=$(echo $file | sed 's|src/main/java/||' | sed 's|.java$|.class|')
    
    echo "File: $file"
    # Ищем покрытие для этого файла в отчете
    if grep -q "$CLASS_FILE" target/site/jacoco/jacoco.xml; then
        echo "  ✓ Found in coverage report"
    else
        echo "  ⚠ Not found in coverage report (maybe not executed)"
    fi
done

echo -e "\n=== Done ==="
