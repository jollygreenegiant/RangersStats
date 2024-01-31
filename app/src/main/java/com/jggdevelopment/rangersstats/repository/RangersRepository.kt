package com.jggdevelopment.rangersstats.repository

import com.jggdevelopment.rangersstats.model.GameCenter
import com.jggdevelopment.rangersstats.model.Roster
import com.jggdevelopment.rangersstats.model.RosterPlayerWithStats
import com.jggdevelopment.rangersstats.model.Schedule
import com.jggdevelopment.rangersstats.model.Standings
import com.jggdevelopment.rangersstats.model.TeamPlayerStats
import com.jggdevelopment.rangersstats.network.NhlApi
import com.jggdevelopment.rangersstats.util.RangersResult

interface RangersRepository {
    suspend fun getRoster(): RangersResult<Roster>
    suspend fun getStandings(): RangersResult<Standings>
    suspend fun getSchedule(): RangersResult<Schedule>
    suspend fun getPlayer(id: Int): RangersResult<RosterPlayerWithStats>
    suspend fun getGame(id: Int): RangersResult<GameCenter>
    suspend fun getTeamStats(teamAbbrev: String): RangersResult<TeamPlayerStats>
}

class RangersRepositoryImpl(
    private val nhlApi: NhlApi
): RangersRepository {
    override suspend fun getRoster() = RangersResult { nhlApi.getRoster() }

    override suspend fun getStandings() = RangersResult { nhlApi.getStandings() }

    override suspend fun getSchedule() = RangersResult { nhlApi.getSchedule() }

    override suspend fun getPlayer(id: Int) = RangersResult { nhlApi.getPlayer(id) }

    override suspend fun getGame(id: Int) = RangersResult { nhlApi.getGame(id) }

    override suspend fun getTeamStats(teamAbbrev: String) = RangersResult { nhlApi.getTeamPlayerStats(teamAbbrev) }
}
