package com.example.calculator.ClassFunObj

import android.util.Log

fun transformMathExpression(expression: String): String {
    Log.d("MyLog", "start transformMathExpression")
    if (expression.isEmpty()) return expression

    val operators = listOf('+', '-', '*', '/')
    var lastOperatorIndex = -1

    // Найти последний оператор в строке
    for (i in expression.indices) {
        if (expression[i] in operators) {
            if (expression[i - 1] == '(') {
                continue // Пропустить, если это часть числа
            }
            lastOperatorIndex = i
        }
    }
    // Разделить выражение на часть до последнего оператора и последнее число
    val beforeLastNumber = if (lastOperatorIndex != -1) expression.substring(0, lastOperatorIndex + 1) else ""
    var lastNumber = if (lastOperatorIndex != -1) expression.substring(lastOperatorIndex + 1) else expression

    // Проверить, обернуто ли последнее число в скобки
    return if (lastNumber.startsWith("(-") && lastNumber.endsWith(")")) {
        // Если уже отрицательное, удалить скобки
        Log.d("MyLog", "end transformMathExpression")
        beforeLastNumber + lastNumber.substring(2, lastNumber.length - 1)
    } else {
        //
        if(lastNumber.startsWith("(") && lastNumber.endsWith(")")){
            lastNumber = lastNumber.substring(1, lastNumber.length - 1)
            // Иначе сделать отрицательным
            Log.d("MyLog", "end transformMathExpression")
            beforeLastNumber + "(-$lastNumber)"
        }
        else if(lastNumber.startsWith("(")){
            lastNumber = lastNumber.substring(1)
            // Иначе сделать отрицательным
            Log.d("MyLog", "end transformMathExpression")
            beforeLastNumber + "(-$lastNumber"
        }
        else{
            // Иначе сделать отрицательным
            Log.d("MyLog", "end transformMathExpression")
            beforeLastNumber + "(-$lastNumber)"
        }
    }
}
