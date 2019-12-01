package ru.rosbank.javaschool.kotlin

open class Person(var name: String, var age: Int)

class RichPerson(name: String, age: Int, val balance: Int) : Person(name, age)

data class Dto(val id: Int, val value: String)

fun <T> List<T>.last(): T = this[this.lastIndex]

fun main() {
    val dto = Dto(1, "Value")
    val copy = dto.copy(id = 2) // named args

    listOf(1, 2, 3, 4).forEach {
        println(it)
    }

    val vasya = Person("Vasya", 20).apply {
        this.name = "VASUA"
    }

    val (name) = dto

    println(listOf(1, 2, 3).last())
}