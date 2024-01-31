package com.jggdevelopment.rangersstats.network

import com.jggdevelopment.rangersstats.model.GameCenter
import com.jggdevelopment.rangersstats.model.Roster
import com.jggdevelopment.rangersstats.model.RosterPlayerWithStats
import com.jggdevelopment.rangersstats.model.Schedule
import com.jggdevelopment.rangersstats.model.Standings
import com.jggdevelopment.rangersstats.model.TeamPlayerStats
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

    @GET("gamecenter/{id}/landing")
    suspend fun getGame(@Path("id") id: Int): GameCenter

    @GET("club-stats/{teamAbbrev}/now")
    suspend fun getTeamPlayerStats(@Path("teamAbbrev") teamAbbrev: String): TeamPlayerStats
}
