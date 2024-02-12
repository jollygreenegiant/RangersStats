package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

data class PlayerLeader(
    @SerializedName("playerId")
    override val id: Int,
    var name: Name,
    override val firstName: Name,
    override val lastName: Name,
    override val positionCode: String,
    override val headshot: String,
    var value: Int
) : Player()
