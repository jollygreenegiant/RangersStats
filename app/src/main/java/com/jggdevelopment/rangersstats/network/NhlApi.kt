package com.jggdevelopment.rangersstats.network

import com.jggdevelopment.rangersstats.model.Roster
import com.jggdevelopment.rangersstats.model.RosterPlayer
import com.jggdevelopment.rangersstats.model.RosterPlayerWithStats
import com.jggdevelopment.rangersstats.model.Schedule
import com.jggdevelopment.rangersstats.model.Standings
import retrofit2.http.GET
import retrofit2.http.Path

interface NhlApi {
    @GET("roster/NYR/20232024")
    suspend fun getRoster(): Roster

    @GET("standings/now")
    suspend fun getStandings(): Standings

    @GET("club-schedule-season/NYR/now")
    suspend fun getSchedule(): Schedule

    @GET("player/{id}/landing")
    suspend fun getPlayer(@Path("id") id: Int): RosterPlayerWithStats
}
