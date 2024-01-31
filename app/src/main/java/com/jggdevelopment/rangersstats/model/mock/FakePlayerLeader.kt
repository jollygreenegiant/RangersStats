package com.jggdevelopment.rangersstats.model.mock

import com.jggdevelopment.rangersstats.model.Name
import com.jggdevelopment.rangersstats.model.PlayerLeader

val fakePlayerLeader1 = PlayerLeader(
    id = 1,
    name = Name("First Last"),
    firstName = Name( "First"),
    lastName = Name("Areallylonglastname"),
    positionCode = "C",
    headshot = "headshot",
    value = 7
)

val fakePlayerLeader2 = PlayerLeader(
    id = 1,
    name = Name("First Last"),
    firstName = Name( "First"),
    lastName = Name("Last"),
    positionCode = "C",
    headshot = "headshot",
    value = 12
)
