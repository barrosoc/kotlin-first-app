package com.codely.demo

import java.time.LocalDate
import java.time.Period

fun main() {
    println("Please enter your birthday with the format <yyy-MM-dd>")
    supportNullableString(readlnOrNull()).takeUnless {
        it.isNullOrBlank() || it.isEmpty()
    }?.let { line ->
        val input = LocalDate.parse(line).also {
            println("Your birthday is $it")
        }

        with(Period.between(input, LocalDate.now())) {
            println("The difference between your birthday and the current date is ${this.years} years")
        }
    }
}

fun supportNullableString(line: String?) = line
