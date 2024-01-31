package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

data class RosterPlayerWithStats(
    override val id: Int,
    override val headshot: String,
    override val firstName: Name,
    override val lastName: Name,
    @SerializedName("position")
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
    val birthStateProvince: Name?,
    val careerTotals: PlayerStats,
    val last5Games: List<PlayerGameStats>,
    val seasonTotals: List<PlayerStats>
): Player()
