package com.example.tutorialapplication

class DerivedChild : Derived() {

//    오버라이드 불가
//    override fun canOverride() {
//        super.canOverride()
//    }

    override fun canOverrideAndNotFinal() {
        super.canOverrideAndNotFinal()
    }
}