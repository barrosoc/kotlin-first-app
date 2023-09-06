package com.codely.demo

import java.time.LocalDate

fun main() {
    println("Please enter a date with the format <yyy-MM-dd>")
    val readlLine: String? = null
    val input = LocalDate.parse(readlLine ?: "2023-04-09")
    println("You wrote $input ${input.dayOfWeek}")
}
