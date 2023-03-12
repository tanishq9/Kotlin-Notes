package main.kotlin

import upperFirstAndLast as ufl
import `object`.SingletonObject as so

fun main() {
    so.method1()
    println(Department.HR.getDeptInfo())
    println("str".ufl())
}
