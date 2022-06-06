package ar.com.composehexagonalarchitecture.data.network.mapper

import ar.com.composehexagonalarchitecture.data.network.model.TeamRest
import ar.com.composehexagonalarchitecture.domain.Team

object TeamMapper {
    fun toDomain(teamRest: TeamRest): Team {
        return Team(
            id = teamRest.id,
            name = teamRest.name,
            fullName = teamRest.fullName,
            abbreviation = teamRest.abbreviation,
            city = teamRest.city,
            conference = teamRest.conference,
            division = teamRest.division
        )
    }
}