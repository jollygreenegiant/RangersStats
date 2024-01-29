package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

data class RosterPlayerWithStats(
    override val id: Int,
    override val headshot: String,
    override val firstName: Name,
    override val lastName: Name,
    override val sweaterNumber: Int,
    @SerializedName("position")
    override val positionCode: String?,
    override val shootsCatches: String,
    override val heightInInches: Int,
    override val weightInPounds: Int,
    override val heightInCentimeters: Int,
    override val weightInKilograms: Int,
    override val birthDate: String,
    override val birthCity: Name?,
    override val birthCountry: String,
    override val birthStateProvince: Name?,
    val careerTotals: PlayerStats,
    val last5Games: List<PlayerGameStats>,
    val seasonTotals: List<PlayerStats>
): Player()
