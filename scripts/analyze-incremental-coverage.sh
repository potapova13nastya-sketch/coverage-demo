#!/bin/bash

set -e

echo "=== Detailed Incremental Coverage Analysis ==="

# Параметры
MIN_COVERAGE=70
JACOCO_REPORT="target/site/jacoco/jacoco.xml"

# Проверяем наличие отчета
if [ ! -f "$JACOCO_REPORT" ]; then
    echo "❌ Error: JaCoCo report not found at $JACOCO_REPORT"
    exit 1
fi

echo "📊 Analyzing coverage report..."

# Извлекаем данные о покрытии
if command -v xmllint &> /dev/null; then
    TOTAL_COVERED=$(xmllint --xpath 'string(/report/counter[@type="LINE"]/@covered)' "$JACOCO_REPORT" 2>/dev/null || echo "0")
    TOTAL_MISSED=$(xmllint --xpath 'string(/report/counter[@type="LINE"]/@missed)' "$JACOCO_REPORT" 2>/dev/null || echo "0")
else
    TOTAL_COVERED=$(grep -oP 'counter type="LINE".*?covered="\K[^"]+' "$JACOCO_REPORT" | head -1 || echo "0")
    TOTAL_MISSED=$(grep -oP 'counter type="LINE".*?missed="\K[^"]+' "$JACOCO_REPORT" | head -1 || echo "0")
fi

echo "✅ Covered lines: $TOTAL_COVERED"
echo "❌ Missed lines: $TOTAL_MISSED"

# Рассчитываем процент покрытия
if [ "$TOTAL_COVERED" = "0" ] && [ "$TOTAL_MISSED" = "0" ]; then
    COVERAGE_PERCENT=0
else
    TOTAL_LINES=$((TOTAL_COVERED + TOTAL_MISSED))
    if [ $TOTAL_LINES -gt 0 ]; then
        COVERAGE_PERCENT=$((TOTAL_COVERED * 100 / TOTAL_LINES))
    else
        COVERAGE_PERCENT=0
    fi
fi

echo "📈 Overall line coverage: ${COVERAGE_PERCENT}%"

# Проверяем порог
if [ $COVERAGE_PERCENT -lt $MIN_COVERAGE ]; then
    echo "❌ FAILURE: Coverage (${COVERAGE_PERCENT}%) is below minimum threshold (${MIN_COVERAGE}%)"
    exit 1
else
    echo "✅ SUCCESS: Coverage (${COVERAGE_PERCENT}%) meets or exceeds threshold (${MIN_COVERAGE}%)"
fi

echo "=== Analysis complete ==="
