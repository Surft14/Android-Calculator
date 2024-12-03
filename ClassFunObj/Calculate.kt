package com.example.calculator.ClassFunObj

import android.service.autofill.FieldClassification.Match
import android.util.Log
import com.example.calculator.*
import kotlin.math.*
import kotlin.math.pow
import kotlin.time.times

class Calculate {
    private var expressionElement = arrayListOf<Element>()
    private var maxPriority: Int = 1

    private fun addNumber(_number: Double, _id: String = Constance.ID_NUMBER){
        expressionElement.add(Element(_id, _number))
        Log.d("MyLog", "fun addNumber. Number = $_number")
    }
    private fun addOperator(_operator: Char, _priority: Int, _id: String = Constance.ID_OPERATOR){
        expressionElement.add(Element(_id, _priority, _operator))
        Log.d("MyLog", "fun addOperator. Operator = $_operator")
    }
    private  fun addMathConst(_number: String, _id: String = Constance.ID_NUMBER){
        if (_number == "e")expressionElement.add(Element(_id, Constance.E ))
        else expressionElement.add(Element(_id, Constance.PI))
        Log.d("MyLog", "fun addMathConst. mathConst = $_number")
    }
    private fun addMathFun(_priority: Int, _mathFun: String, _id: String = Constance.ID_MATH_FUN){
        expressionElement.add(Element(_priority, _mathFun))
        Log.d("MyLog", "fun addMathConst. mathFun = $_mathFun, id = $_id, priority = $_priority")
    }

    private fun ads(number: Double?): Double {
        return if (number!! < 0) number * -1
        else number
    }
    private fun factorial(number: Double): Double {
        var result = 1
        for (i in 1..number.toInt()) {
            result *= i
        }

        return result.toDouble()
    }
    private fun sqrt(number: Double): Double{
        return number.pow(0.5)
    }
    private fun cubrt(number: Double): Double{
        return number.pow(0.3333333333333333)
    }

    fun addToArray(charArray: CharArray) {
        Log.d("MyLog", "fun addToArray start")
        var number = ""
        var mathFun = ""
        var priority = 0
        var nowPrecent = false

        var negNumber = false
        var mathFunB = false
         for(elem: Char in charArray){
            if ( !mathFunB && (elem == '0'
                || elem == '1'
                || elem == '2'
                || elem == '3'
                || elem == '4'
                || elem == '5'
                || elem == '6'
                || elem == '7'
                || elem == '8'
                || elem == '9'
                || elem == '.'
                || elem == 'e'
                || elem == 'p'
                || elem == 'i')){
                number += elem
                nowPrecent = false
                negNumber = false
                Log.i("MyLog", "fun addToArray. Element = $elem num")
            }
            else if(elem == 'a' // abs
                || elem == 'b' // !
                || elem == 's' // sqrt
                || elem == '!' // cubrt
                || elem == 'q' // cos
                || elem == 'r'
                || elem == 't'
                || elem == 'c'
                || elem == 'u'
                || elem == 'n'
                || elem == 'i'
                || elem == 'o'
                || elem == 'l'
                || elem == 'g'
                || elem == 'h'){
                mathFunB = true
                nowPrecent = false
                mathFun += elem
                Log.i("MyLog", "fun addToArray. Element = $elem math")

                if((mathFun == "abs"
                    || mathFun == "!"
                    || mathFun == "sqrt"
                    || mathFun == "cubrt"
                    || mathFun == "sin"
                    || mathFun == "cos"
                    || mathFun == "tan"
                    || mathFun == "asin"
                    || mathFun == "acos"
                    || mathFun == "atan"
                    || mathFun == "log"
                    || mathFun == "ln")
                    && !hyper
                ) {
                    addMathFun(priority + 1, mathFun)
                    mathFunB = false
                }
                else if ((mathFun == "sinh"
                    || mathFun == "cosh"
                    || mathFun == "tanh"
                    || mathFun == "asinh"
                    || mathFun == "acosh"
                    || mathFun == "atanh") && hyper){
                    addMathFun(priority + 1, mathFun)
                    mathFunB = false
                    hyper = false
                }
            }
            else if(elem == '('){
                negNumber = true
                priority += 3
                if ( maxPriority < priority ) maxPriority = priority
            }
            else if(elem == ')'){
                negNumber = false
                priority -= 3
            }
            else if(elem == '+'
                || elem == '-'
                || elem == '*'
                || elem == '/'
                || elem == '%'
                || elem == '^'){
                Log.i("MyLog", "fun addToArray. Number = $number")
                if(elem == '%'){
                    addOperator(elem,priority + 3)
                    if ( maxPriority < 3 ) maxPriority = 3
                    nowPrecent = true
                }
                else if(!negNumber && number != "pi" && number != "e") {
                    addNumber(number.toDouble())
                }
                else if(number == "pi" || number == "e") {
                    addMathConst(number)
                }

                if (elem == '*' || elem == '/'){
                    addOperator(elem,priority + 2)
                    if ( maxPriority < 2 ) maxPriority = 2
                }
                else if(elem == '-' && negNumber){
                    number += elem
                }
                else if (elem == '^'){
                    addOperator(elem,priority + 3)
                    if ( maxPriority < 3 ) maxPriority = 3
                }
                else if(elem == '-' || elem == '+'){
                    addOperator(elem,priority)
                }

                mathFun = ""
                if(!negNumber && !nowPrecent) number = ""
                Log.i("MyLog", "fun addToArray. Element = $elem op")
            }
            if ( maxPriority < priority ) maxPriority = priority
        }
        if(number == "pi" || number == "e") {
            addMathConst(number)
        }
        else {
            addNumber(number.toDouble())
        }
        Log.d("MyLog", "fun addToArray finish. Size ${expressionElement.size}")
        Log.i("MyLog", "Array: ${expressionElement}")
    }

    fun finishCalculate(): Double {
        Log.d("MyLog", "fun finishCalculate start")
        var lastNumber: Double? = null
        var firstNumber: Double? = null
        var secondNumber: Double? = null
        var aFirstNumber: Double? = null
        var operator: Char? = null
        var mathFun: String? = null
        val tempExampleElement = arrayListOf<Element>()
        var decided = false
        Log.i("MyLog", "maxPriority = $maxPriority")
        Log.i("MyLog", "expressionElement.size = ${expressionElement.size}")
        for (i in maxPriority downTo 0) {
            for (j in 0 until expressionElement.size) {
                if(expressionElement[j].id == Constance.ID_NUMBER){
                    lastNumber = expressionElement[j].value!!
                }
                else if (expressionElement[j].id == Constance.ID_OPERATOR && expressionElement[j].priority == i) {
                    operator = expressionElement[j].operator
                    if(expressionElement[j - 1].value != null && operator != '%'){
                        firstNumber = expressionElement[j - 1].value
                    }
                    secondNumber = expressionElement[j + 1].value!!
                    when (operator) {
                        '+' -> {
                            expressionElement[j + 1].id = Constance.ID_NUMBER
                            expressionElement[j + 1].value = firstNumber?.plus(secondNumber)
                            Log.i("MyLog", "$firstNumber + $secondNumber")
                            decided = true
                        }

                        '-' -> {
                            expressionElement[j + 1].id = Constance.ID_NUMBER
                            expressionElement[j + 1].value = firstNumber?.minus(secondNumber)
                            Log.i("MyLog", "$firstNumber - $secondNumber")
                            decided = true
                        }

                        '*' -> {
                            expressionElement[j + 1].id = Constance.ID_NUMBER
                            expressionElement[j + 1].value = firstNumber!! * secondNumber
                            Log.i("MyLog", "$firstNumber * $secondNumber")
                            decided = true
                        }

                        '/' -> {
                            expressionElement[j + 1].id = Constance.ID_NUMBER
                            expressionElement[j + 1].value = firstNumber!! / secondNumber
                            Log.i("MyLog", "$firstNumber / $secondNumber")
                            decided = true
                        }

                        '%' -> {
                            expressionElement[j + 1].id = Constance.ID_NUMBER
                            if (lastNumber == null) expressionElement[j + 1].value = 1.0
                            else expressionElement[j + 1].value = secondNumber * lastNumber / 100
                            Log.i("MyLog", "$secondNumber")
                            decided = true
                        }
                        '^'->{
                            expressionElement[j + 1].id = Constance.ID_NUMBER
                            expressionElement[j + 1].value = firstNumber?.pow(secondNumber)
                            Log.i("MyLog", "$firstNumber^($secondNumber)")
                            decided = true
                        }
                    }
                    Log.d("MyLog", "Start Create empty element")
                    if(operator != '%'){
                        expressionElement[j - 1].value = null
                        expressionElement[j - 1].id = Constance.EMPTY
                    }
                    expressionElement[j].operator = null
                    expressionElement[j].priority = null
                    expressionElement[j].id = Constance.EMPTY
                    Log.d("MyLog", "End Create empty element")
                }
                else if(expressionElement[j].id == Constance.ID_MATH_FUN && expressionElement[j].priority == i){
                    mathFun = expressionElement[j].mathFun
                    aFirstNumber = expressionElement[j+1].value
                    firstNumber = if (radNDeg)
                        expressionElement[j+1].value
                    else
                        expressionElement[j+1].value!! / 180 * Constance.PI
                    when(mathFun){
                        "abs"->{
                            expressionElement[j+1].value = ads(aFirstNumber)
                            Log.i("MyLog", "abs$aFirstNumber")
                            decided = true
                        }
                        "!"->{
                            expressionElement[j+1].value = factorial(aFirstNumber!!)
                            Log.i("MyLog", "factorial$aFirstNumber")
                            decided = true
                        }
                        "sqrt"->{
                            expressionElement[j+1].value = sqrt(aFirstNumber!!)
                            Log.i("MyLog", "sqrt$aFirstNumber")
                            decided = true
                        }
                        "cubrt"->{
                            expressionElement[j+1].value = cubrt(aFirstNumber!!)
                            Log.i("MyLog", "cubrt$aFirstNumber")
                            decided = true
                        }
                        "sin"->{
                            expressionElement[j+1].value = sin(firstNumber!!)
                            Log.i("MyLog", "sin$firstNumber")
                            decided = true
                        }
                        "cos"->{
                            expressionElement[j+1].value = cos(firstNumber!!)
                            Log.i("MyLog", "cos$firstNumber")
                            decided = true
                        }
                        "tan"->{
                            expressionElement[j+1].value = tan(firstNumber!!)
                            Log.i("MyLog", "tan$firstNumber")
                            decided = true
                        }
                        "asin"->{
                            expressionElement[j+1].value = asin(aFirstNumber!!) * 180 / Constance.PI
                            Log.i("MyLog", "asin$aFirstNumber")
                            decided = true
                        }
                        "acos"->{
                            expressionElement[j+1].value = acos(aFirstNumber!!) * 180 / Constance.PI
                            Log.i("MyLog", "acos$aFirstNumber")
                            decided = true
                        }
                        "atan"->{
                            expressionElement[j+1].value = atan(aFirstNumber!!) * 180 / Constance.PI
                            Log.i("MyLog", "atan$aFirstNumber")
                            decided = true
                        }
                        "ln"->{
                            expressionElement[j+1].value = ln(aFirstNumber!!)
                            Log.i("MyLog", "ln$aFirstNumber")
                            decided = true
                        }
                        "log"->{
                            expressionElement[j+1].value = log2(aFirstNumber!!)
                            Log.i("MyLog", "log$aFirstNumber = ${log2(aFirstNumber)}")
                            decided = true
                        }
                        "sinh"->{
                            expressionElement[j+1].value = sinh(aFirstNumber!!)
                            Log.i("MyLog", "sinh$aFirstNumber")
                            decided = true
                        }
                        "cosh"->{
                            expressionElement[j+ 1].value = cosh(aFirstNumber!!)
                            Log.i("MyLog", "sinh$aFirstNumber")
                            decided = true
                        }
                        "tanh"->{
                            expressionElement[j+1].value = atanh(aFirstNumber!!)
                            Log.i("MyLog", "sinh$aFirstNumber")
                            decided = true
                        }
                        "asinh"->{
                            expressionElement[j+1].value = asinh(aFirstNumber!!) * 180 / Constance.PI
                            Log.i("MyLog", "sinh$aFirstNumber")
                            decided = true
                        }
                        "acosh"->{
                            expressionElement[j+ 1].value = acosh(aFirstNumber!!) * 180 / Constance.PI
                            Log.i("MyLog", "sinh$aFirstNumber")
                            decided = true
                        }
                        "atanh"->{
                            expressionElement[j+1].value = atanh(aFirstNumber!!) * 180 / Constance.PI
                            Log.i("MyLog", "sinh$aFirstNumber")
                            decided = true
                        }

                    }
                    Log.d("MyLog", "Start Create empty element")
                    expressionElement[j].operator = null
                    expressionElement[j].priority = null
                    expressionElement[j].mathFun = null
                    expressionElement[j].id = Constance.EMPTY
                    Log.d("MyLog", "End Create empty element")
                }
            }
            if(decided){
                Log.d("MyLog", "Start reWrite array")
                tempExampleElement.addAll(expressionElement)
                expressionElement.clear()
                for (j in tempExampleElement) {
                    Log.d("MyLog", "rewriting...")
                    Log.i(
                        "MyLog",
                        "id = ${j.id}, value = ${j.value}, operator = ${j.operator}, priority = ${j.priority}, mathFun = ${j.mathFun}"
                    )
                    if (j.id != Constance.EMPTY) {
                        expressionElement.add(j)
                    }
                }
                Log.i("MyLog", "Size array = ${expressionElement.size}")
                tempExampleElement.clear()
                Log.d("MyLog", "End reWrite array")
            }
        }
        Log.i("MyLog", "fun return = ${expressionElement[expressionElement.lastIndex].value}, size = ${expressionElement.size}")
        Log.d("MyLog", "fun finishCalculate end")
        val result = expressionElement[expressionElement.lastIndex].value!!
        expressionElement.clear()
        maxPriority = 1
        return result
    }



}