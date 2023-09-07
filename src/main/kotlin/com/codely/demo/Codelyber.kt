package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter your birthday with the format <yyy-MM-dd>")
    supportNullableString(readLine()).takeIf {
        !it.isNullOrBlank() && it.isNotEmpty()
    }?.let { line ->
        LocalDate.parse(line)
    }.apply {
        if (this == null) {
            println("The input date is not valid")
            exitProcess(1)
        }
    }.also {
        println("Your birthday is $it")
    }?.run {
        calculateDifference()
    }
}

fun supportNullableString(line: String?) = line
private fun LocalDate.calculateDifference() = with(Period.between(this, LocalDate.now())) {
    val baseMessage = "The difference between your birthday and the current date is "
    val clinkingBeerMugsEmoji = "\uD83C\uDF7B"
    when {
        years >= 18 -> println("$baseMessage $years years. Your are of age! $clinkingBeerMugsEmoji")
        years > 0 -> println("$baseMessage $years years")
        months > 0 -> println("$baseMessage $months months")
        days > 0 -> println("$baseMessage $days days")
    }
}
