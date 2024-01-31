package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

abstract class Player {
    abstract val id: Int
    abstract val headshot: String
    abstract val firstName: Name
    abstract val lastName: Name
    abstract val positionCode: String?

    val positionString
        get() = when (positionCode) {
            "C" -> "Center"
            "L" -> "Left Wing"
            "R" -> "Right Wing"
            "D" -> "Defenseman"
            "G" -> "Goalie"
            else -> "Unknown"
        }

    val shortPositionString
        get() = when (positionCode) {
            "C" -> "C"
            "L" -> "LW"
            "R" -> "RW"
            "D" -> "D"
            "G" -> "G"
            else -> "??"
        }

    val fullName
        get() = "${firstName.default} ${lastName.default}"
}

data class RosterPlayer(
    override val id: Int,
    override val headshot: String,
    override val firstName: Name,
    override val lastName: Name,
    override val positionCode: String?,
    val sweaterNumber: Int,
    val shootsCatches: String,
    val heightInInches: Int,
    val weightInPounds: Int,
    val heightInCentimeters: Int,
    val weightInKilograms: Int,
    val birthDate: String,
    val birthCity: Name?,
    val birthCountry: String,
    val birthStateProvince: Name?
): Player()

data class Name(
    val default: String
)
