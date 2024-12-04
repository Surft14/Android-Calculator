package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.ClassFunObj.Calculate
import com.example.calculator.ClassFunObj.transformMathExpression
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding
    private lateinit var buttonNumber: Button
    private lateinit var buttonOperator: Button
    private var pressedNumber: Boolean = false
    private var pressedPoint1: Boolean = false
    private var pressedPoint2: Boolean = false
    private var swap: Boolean = false
    private var calculate = Calculate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(bindingClass.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("MyLog", "Create activity")
    }

    private fun clickPi() {
        Log.d("MyLog", "Button pi click")
        var tempText = bindingClass.tvResult.text.toString()

        if (tempText == "0" && !swap) {
            bindingClass.tvResult.text = "pi"
        } else if ((tempText[tempText.lastIndex] == '+'
                    || tempText[tempText.lastIndex] == '-'
                    || tempText[tempText.lastIndex] == '*'
                    || tempText[tempText.lastIndex] == '/') && !swap
        ) {
            tempText += "pi"
            bindingClass.tvResult.text = tempText
        }

    }

    private fun clickASin() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "asin("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*asin("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "asin("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickACos() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "acos("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*acos("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "acos("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickATan() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "atan("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*atan("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "atan("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickSin() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "sin("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*sin("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "sin("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickCos() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "cos("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*cos("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "cos("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickTan() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "tan("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*tan("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "tan("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickE() {
        Log.d("MyLog", "Button e click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0" && !swap) {
            bindingClass.tvResult.setText("e")
        } else if ((tempText[tempText.lastIndex] == '+'
                    || tempText[tempText.lastIndex] == '-'
                    || tempText[tempText.lastIndex] == '*'
                    || tempText[tempText.lastIndex] == '/') && !swap
        ) {
            tempText += "e"
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickPow2() {
        Log.d("MyLog", "Button pow 2 click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText != "0" &&
            (tempText[tempText.lastIndex] != '+'
                    || tempText[tempText.lastIndex] != '-'
                    || tempText[tempText.lastIndex] != '*'
                    || tempText[tempText.lastIndex] != '/')
        ) {
            tempText += "^(2)"
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickAbs() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "abs("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*abs("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "abs("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickSqrt() {
        Log.d("MyLog", "Button Sqrt click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "sqrt("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*sqrt("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "sqrt("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickCubrt() {
        Log.d("MyLog", "Button Sqrt click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "cubrt("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*cubrt("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "cubrt("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickFactorial() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText != "0" && (
                    tempText[tempText.lastIndex] == '0'
                            || tempText[tempText.lastIndex] == '1'
                            || tempText[tempText.lastIndex] == '2'
                            || tempText[tempText.lastIndex] == '3'
                            || tempText[tempText.lastIndex] == '4'
                            || tempText[tempText.lastIndex] == '5'
                            || tempText[tempText.lastIndex] == '6'
                            || tempText[tempText.lastIndex] == '7'
                            || tempText[tempText.lastIndex] == '8'
                            || tempText[tempText.lastIndex] == '9'
                )){
            tempText += "!"
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickXPow3() {
        Log.d("MyLog", "Button pow 2 click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText != "0" &&
            (tempText[tempText.lastIndex] != '+'
                    || tempText[tempText.lastIndex] != '-'
                    || tempText[tempText.lastIndex] != '*'
                    || tempText[tempText.lastIndex] != '/')
        ) {
            tempText += "^(3)"
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickPowY() {
        Log.d("MyLog", "Button pow 2 click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText != "0" &&
            (tempText[tempText.lastIndex] != '+'
                    || tempText[tempText.lastIndex] != '-'
                    || tempText[tempText.lastIndex] != '*'
                    || tempText[tempText.lastIndex] != '/')
        ) {
            tempText += "^("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickExpPowX() {
        Log.d("MyLog", "Button e pow x click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0") {
            tempText = "e^("
            bindingClass.tvResult.text = tempText
        } else if (tempText[tempText.lastIndex] != '0'
            || tempText[tempText.lastIndex] != '1'
            || tempText[tempText.lastIndex] != '2'
            || tempText[tempText.lastIndex] != '3'
            || tempText[tempText.lastIndex] != '4'
            || tempText[tempText.lastIndex] != '5'
            || tempText[tempText.lastIndex] != '6'
            || tempText[tempText.lastIndex] != '7'
            || tempText[tempText.lastIndex] != '8'
            || tempText[tempText.lastIndex] != '9'
        ) {
            tempText += "e^("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickFraction() {
        Log.d("MyLog", "Button Fractio click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0") {
            tempText = "1/"
            bindingClass.tvResult.text = tempText
        } else if (tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'
        ) {
            tempText += "*1/"
            bindingClass.tvResult.text = tempText
        } else if (tempText[tempText.lastIndex] == '+'
            || tempText[tempText.lastIndex] == '-'
            || tempText[tempText.lastIndex] == '*'
            || tempText[tempText.lastIndex] == '/'
        ) {
            tempText += "1/"
            bindingClass.tvResult.text = tempText
        }
    }

    private fun click2Pow() {
        Log.d("MyLog", "Button e pow x click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0") {
            tempText = "2^("
            bindingClass.tvResult.text = tempText
        } else if (tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'
        ) {
            tempText += "+2^("
            bindingClass.tvResult.text = tempText
        } else {
            tempText += "2^("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickTanh() {
        Log.d("MyLog", "Button abs click")
        hyper = true
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "tanh("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*tanh("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "tanh("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickSinh() {
        Log.d("MyLog", "Button abs click")
        hyper = true
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "sinh("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*sinh("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "sinh("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickCosh() {
        Log.d("MyLog", "Button abs click")
        hyper = true
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "cosh("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*cosh("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "cosh("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickLn() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "ln("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*ln("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "ln("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickLog() {
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "log("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*log("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "log("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickASinh() {
        hyper = true
        Log.d("MyLog", "Button abs click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "asinh("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*asinh("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "asinh("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickACosh() {
        Log.d("MyLog", "Button abs click")
        hyper = true
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "acosh("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*acosh("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "acosh("
            bindingClass.tvResult.text = tempText
        }
    }

    private fun clickATanh() {
        Log.d("MyLog", "Button abs click")
        hyper = true
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0"){
            tempText = "atanh("
            bindingClass.tvResult.text = tempText
        }
        else if(tempText[tempText.lastIndex] == '0'
            || tempText[tempText.lastIndex] == '1'
            || tempText[tempText.lastIndex] == '2'
            || tempText[tempText.lastIndex] == '3'
            || tempText[tempText.lastIndex] == '4'
            || tempText[tempText.lastIndex] == '5'
            || tempText[tempText.lastIndex] == '6'
            || tempText[tempText.lastIndex] == '7'
            || tempText[tempText.lastIndex] == '8'
            || tempText[tempText.lastIndex] == '9'){
            tempText += "*atanh("
            bindingClass.tvResult.text = tempText
        }
        else {
            tempText += "atanh("
            bindingClass.tvResult.text = tempText
        }
    }


    fun onClickAnswer(view: View) {
        Log.d("MyLog", "Click button answer.")
        val charArray = bindingClass.tvResult.text.toString().toCharArray()
        calculate.addToArray(charArray)
        val result = calculate.finishCalculate()
        Log.i("MyLog", "Result = $result")
        if (result.toString()[result.toString().lastIndex] == '0'
            && result.toString()[result.toString().lastIndex - 1] == '.'
        )
            if (result < 0) bindingClass.tvResult.text = "(" + result.toInt().toString() + ")"
            else bindingClass.tvResult.text = result.toInt().toString()
        else
            if (result < 0) bindingClass.tvResult.text = "(" + result.toString() + ")"
            else bindingClass.tvResult.text = result.toString()
    }

    fun onClickPosNeg(view: View) {
        Log.d("MyLog", "Click button Pos or Neg")
        val tempText = bindingClass.tvResult.text.toString()
        if (tempText != "0") {
            val result = transformMathExpression(tempText)
            bindingClass.tvResult.text = result
        }
    }

    fun onClickPoint(view: View) {
        Log.d("MyLog", "Click button point")
        var tempText = bindingClass.tvResult.text.toString()
        if (!pressedPoint1 && !pressedPoint2 && tempText != "0" && tempText[tempText.lastIndex] != ')') {
            tempText += "."
            bindingClass.tvResult.text = tempText
            pressedPoint1 = true
            pressedPoint2 = true
        }
    }

    fun onClickBrackets(view: View) {
        var tempText = bindingClass.tvResult.text.toString()
        if (!pressedNumber && tempText == "0") {
            tempText = "("
            bindingClass.tvResult.text = tempText
            Log.d("MyLog", "Click button Brackets: \"(\" pressedNumber: $pressedNumber")
        } else if (!pressedNumber && tempText[tempText.lastIndex] != ')') {
            tempText += "("
            bindingClass.tvResult.text = tempText
            Log.d("MyLog", "Click button Brackets: \"(\" pressedNumber: $pressedNumber")
        } else if (pressedNumber) {
            tempText += ")"
            bindingClass.tvResult.text = tempText
            Log.d("MyLog", "Click button Brackets: \")\" pressedNumber: $pressedNumber")
        }
    }

    fun onClickPrecent(view: View){
        Log.d("MyLog", "Button precent click")
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText != "0" &&
                (tempText[tempText.lastIndex] == '0'
                    || tempText[tempText.lastIndex] == '1'
                    || tempText[tempText.lastIndex] == '2'
                    || tempText[tempText.lastIndex] == '3'
                    || tempText[tempText.lastIndex] == '4'
                    || tempText[tempText.lastIndex] == '5'
                    || tempText[tempText.lastIndex] == '6'
                    || tempText[tempText.lastIndex] == '7'
                    || tempText[tempText.lastIndex] == '8'
                    || tempText[tempText.lastIndex] == '9')){
            tempText += "%"
            bindingClass.tvResult.text = tempText
        }

    }

    fun onClickOperators(view: View) {
        buttonOperator = findViewById(view.id)
        val size = bindingClass.tvResult.text.length
        var tempText = bindingClass.tvResult.text.toString()
        val charArray = tempText.toCharArray()

        if (tempText != "0"
            && tempText[size - 1].toString() != "+"
            && tempText[size - 1].toString() != "-"
            && tempText[size - 1].toString() != "*"
            && tempText[size - 1].toString() != "/"
        ) {
            Log.d("MyLog", "Click button Operators: ${buttonOperator.text}")
            tempText += buttonOperator.text.toString()
            bindingClass.tvResult.text = tempText
        } else if (tempText != "0"
            && (tempText[size - 1].toString() == "+"
                    || tempText[size - 1].toString() == "-"
                    || tempText[size - 1].toString() == "*"
                    || tempText[size - 1].toString() == "/")
        ) {
            Log.d("MyLog", "Click button replacement Operators: ${buttonOperator.text}")
            charArray[charArray.lastIndex] = buttonOperator.text.toString().first()
            tempText = String(charArray)
            bindingClass.tvResult.text = tempText
        }
        pressedNumber = false
        pressedPoint1 = false
        pressedPoint2 = true
    }

    fun onClickNumbers(view: View) {
        buttonNumber = findViewById(view.id)
        var tempText = bindingClass.tvResult.text.toString()
        if (tempText == "0") {
            bindingClass.tvResult.text = buttonNumber.text
        } else {
            if (tempText[tempText.lastIndex] != ')' && tempText[tempText.lastIndex] != '!') {
                tempText += buttonNumber.text.toString()
                bindingClass.tvResult.text = tempText
            }
        }
        pressedNumber = true
        pressedPoint2 = false
        Log.d("MyLog", "Click button Number: ${buttonNumber.text}")
    }

    fun onClickCleanUp(view: View) {
        Log.d("MyLog", "Click button Clean up")
        bindingClass.tvResult.setText(R.string.zero)
        pressedNumber = false
        pressedPoint1 = false
        pressedPoint2 = false
    }

    fun onClickSwap(view: View) {
        if (!swap) {
            swap = true

            bindingClass.bSqrtCubrt?.setText(R.string.cubrt)
            bindingClass.bSinNAsin?.setText(R.string.sin_pow_minus_one)
            bindingClass.bCosNAcos?.setText(R.string.cos_pow_minus_one)
            bindingClass.bTanNAtan?.setText(R.string.tan_pow_minus_one)

            bindingClass.bInNSinh?.setText(R.string.sinh)
            bindingClass.bLogNCosh?.setText(R.string.cosh)
            bindingClass.bFractionNTanh?.setText(R.string.tanh)

            bindingClass.bExpPowXNSinhPowMin1?.setText(R.string.sinh_pow_minus_one)
            bindingClass.bPow2NCoshPowMin1?.setText(R.string.cosh_pow_minus_one)
            bindingClass.bPowYNTanhPowMin1?.setText(R.string.tanh_pow_minus_one)

            bindingClass.bAbsN2PowX?.setText(R.string.two_pow_x)
            bindingClass.bPiNPowCube?.setText(R.string.x_pow_cube)
            bindingClass.bExpNFactorial?.setText(R.string.x_factorial)

        } else {
            swap = false

            bindingClass.bSqrtCubrt?.setText(R.string.sqr)
            bindingClass.bSinNAsin?.setText(R.string.sin)
            bindingClass.bCosNAcos?.setText(R.string.cos)
            bindingClass.bTanNAtan?.setText(R.string.tan)

            bindingClass.bInNSinh?.setText(R.string._in)
            bindingClass.bLogNCosh?.setText(R.string.log)
            bindingClass.bFractionNTanh?.setText(R.string.fraction)

            bindingClass.bExpPowXNSinhPowMin1?.setText(R.string.exp_power_x)
            bindingClass.bPow2NCoshPowMin1?.setText(R.string.power_two)
            bindingClass.bPowYNTanhPowMin1?.setText(R.string.power_y)

            bindingClass.bAbsN2PowX?.setText(R.string.abs)
            bindingClass.bPiNPowCube?.setText(R.string.pi)
            bindingClass.bExpNFactorial?.setText(R.string.exp)
        }
    }

    fun onClickRadNDeg(view: View) {
        if (!radNDeg) {
            radNDeg = true
            bindingClass.bRadNDeg?.setText(R.string.degrees)
        } else {
            radNDeg = false
            bindingClass.bRadNDeg?.setText(R.string.rad)
        }
    }

    fun onClickBPiNPowCube(view: View) {
        if (!swap) clickPi()
        else clickXPow3()
    }

    fun onClickBExpNFactorial(view: View) {
        if (!swap) clickE()
        else clickFactorial()
    }

    fun onClickBPow2NCoshPowMin1(view: View) {
        if (!swap) clickPow2()
        else clickACosh()
    }

    fun onClickBPowYNTanhPowMin1(view: View) {
        if (!swap) clickPowY()
        else clickATanh()
    }

    fun onClickBExpPowXNSinhPowMin1(view: View) {
        if (!swap) clickExpPowX()
        else clickASinh()
    }

    fun onClickBAbsN2PowX(view: View) {
        if (swap) click2Pow()
        else clickAbs()
    }

    fun onClickBSqrtCubrt(view: View){
        if (!swap) clickSqrt()
        else clickCubrt()
    }

    fun onClickBSinNASin(view: View){
        if (!swap) clickSin()
        else clickASin()
    }

    fun onClickBCosNACos(view: View){
        if (!swap) clickCos()
        else clickACos()
    }

    fun onClickBTanNACan(view: View){
        if (!swap) clickTan()
        else clickATan()
    }

    fun onClickBFractionNTanh(view: View) {
        if (!swap) clickFraction()
        else clickTanh()
    }

    fun onClickBInNSinh(view: View){
        if (!swap) clickLn()
        else clickSinh()
    }

    fun onClickBLogNCosh(view: View){
        if(!swap) clickLog()
        else clickCosh()
    }

    fun onClickBCancel(view: View){
        Log.d("MyLog", "Button clean click")
        var tempText = bindingClass.tvResult.text.toString()
        if(tempText != "0"){
            tempText = tempText.substring(0, tempText.length - 1)
            if (tempText == ""){
                tempText = "0"
            }
            bindingClass.tvResult.text = tempText
        }
    }

}