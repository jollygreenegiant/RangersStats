package com.jggdevelopment.rangersstats.repository

import com.jggdevelopment.rangersstats.network.NhlApi
import com.jggdevelopment.rangersstats.util.RangersResult

class RangersRepository(
    val nhlApi: NhlApi
) {
    suspend fun getRoster() = RangersResult { nhlApi.getRoster() }

    suspend fun getStandings() = RangersResult { nhlApi.getStandings() }

    suspend fun getSchedule() = RangersResult { nhlApi.getSchedule() }

    suspend fun getPlayer(id: Int) = RangersResult { nhlApi.getPlayer(id) }
}
