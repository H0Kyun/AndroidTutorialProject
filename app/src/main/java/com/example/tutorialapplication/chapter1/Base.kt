package com.example.tutorialapplication.chapter1

open class Base(open val mutableProperty: Int) {

    open val propertyForOverride = 4
    open fun canOverride() {}
    open fun canOverrideAndNotFinal() {}
    fun canNotOverride() {}
}