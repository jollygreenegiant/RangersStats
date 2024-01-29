package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

abstract class Player {
    abstract val id: Int
    abstract val headshot: String
    abstract val firstName: Name
    abstract val lastName: Name
    abstract val sweaterNumber: Int
    abstract val positionCode: String?
    abstract val shootsCatches: String
    abstract val heightInInches: Int
    abstract val weightInPounds: Int
    abstract val heightInCentimeters: Int
    abstract val weightInKilograms: Int
    abstract val birthDate: String
    abstract val birthCity: Name?
    abstract val birthCountry: String
    abstract val birthStateProvince: Name?

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

    val heightInFreedomUnits
        get() = "${heightInInches / 12}' ${heightInInches % 12}\""
}

data class RosterPlayer(
    override val id: Int,
    override val headshot: String,
    override val firstName: Name,
    override val lastName: Name,
    override val sweaterNumber: Int,
    override val positionCode: String?,
    override val shootsCatches: String,
    override val heightInInches: Int,
    override val weightInPounds: Int,
    override val heightInCentimeters: Int,
    override val weightInKilograms: Int,
    override val birthDate: String,
    override val birthCity: Name?,
    override val birthCountry: String,
    override val birthStateProvince: Name?
): Player()

data class Name(
    val default: String
)
