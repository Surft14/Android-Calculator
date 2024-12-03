package com.example.calculator.ClassFunObj
class Element {
    var id: String = Constance.EMPTY
    var priority: Int? = null
    var value: Double? = null
    var operator: Char? = null
    var mathFun: String? = null

    constructor(_id: String, _value: Double){ // number
        id = _id
        value = _value
    }

    constructor(_id: String, _priority: Int, _operator: Char){ //operator
        id = _id
        priority = _priority
        operator = _operator
    }

    constructor(_priority: Int, _mathFun: String, _id: String = Constance.ID_MATH_FUN){ // math fun
        id = _id
        priority = _priority
        mathFun = _mathFun
    }

}