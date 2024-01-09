package com.example.tutorialapplication

open class Base(open val mutableProperty: Int) {

    open val propertyForOverride = 4
    open fun canOverride() {}
    open fun canOverrideAndNotFinal() {}
    fun canNotOverride() {}
}