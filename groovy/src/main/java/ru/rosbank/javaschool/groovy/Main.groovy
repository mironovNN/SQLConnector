package ru.rosbank.javaschool.groovy

def variable = 'value'
println("Hello ${variable}")

println "Hello ${variable}"

def funcWithoutArg() {
    println 'Func without arg'
}

funcWithoutArg()

def funcWithArg(a, b) {
    println a
    println b
}

funcWithArg "hello", "world"

def closure = {
    // it
    println "closure"
    println it // <- 'value'
}

closure "value"

[1, 2, 3].forEach {
    println it
}

[1, 2, 3].forEach { value ->
    println value
}

// DSL -> Domain Specific Language
class Person {
    def name
}

vasya = new Person()
vasya.name = 'Vasya'

// delegation

def delegate = {
    println name
}

delegate.delegate = vasya
delegate()