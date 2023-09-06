package com.codely.demo

import java.time.LocalDate

fun main() {
    println("Please enter a date with the format <yyy-MM-dd>")
    val input = LocalDate.parse(readlnOrNull())
    println("You wrote $input ${input.dayOfWeek}")
}
