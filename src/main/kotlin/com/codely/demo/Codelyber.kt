package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter your birthday with the format <yyy-MM-dd>")
    supportNullableString(readlnOrNull()).takeIf {
        !it.isNullOrBlank() && it.isNotEmpty()
    }?.let { line ->
        LocalDate.parse(line)
    }.apply {
        if(this == null) {
            println("The input date is not valid")
            exitProcess(1)
        }
    }.also {
        println("Your birthday is $it")
    }.run {
        with(Period.between(this, LocalDate.now())) {
            when {
                years > 0 -> println("The difference between your birthday and the current date is $years years")
                months > 0 -> println("The difference between your birthday and the current date is $months months")
                days > 0 -> println("The difference between your birthday and the current date is $days days")
            }
        }
    }
}

fun supportNullableString(line: String?) = line
