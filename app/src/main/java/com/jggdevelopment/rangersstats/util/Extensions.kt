package com.jggdevelopment.rangersstats.util

fun inchesToFeetAndInches(inches: Int): String {
    return "${inches / 12}' ${inches % 12}\""
}
