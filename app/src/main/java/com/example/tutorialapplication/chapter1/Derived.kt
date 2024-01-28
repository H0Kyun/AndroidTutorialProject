package com.example.tutorialapplication.chapter1

open class Derived(override val mutableProperty: Int = 10) : Base(mutableProperty) {
    final override fun canOverride() {
        super.canOverride()
        print(mutableProperty)
    }

    override fun canOverrideAndNotFinal() {
        super.canOverrideAndNotFinal()
    }
}

fun main() {
    Derived(10).canOverride()

    var callHello: (Int) -> Unit = {
        quantity -> print(quantity)
    }
    callHello = ::printHello
    callHello(30)
    otherFunction() { print("Hello") }
    repeat(4) {
        action -> print("$action Hello")
    }
}

fun printHello(number: Int) {
    print(number)
}

fun otherFunction(callHello: () -> Unit): () -> Unit {
    return callHello
}