package com.jggdevelopment.rangersstats.model

import com.google.gson.annotations.SerializedName

data class PlayerLeader(
    @SerializedName("playerId")
    override var id: Int,
    var name: Name,
    override val firstName: Name,
    override val lastName: Name,
    override var positionCode: String,
    override var headshot: String,
    var value: Int
) : Player()
