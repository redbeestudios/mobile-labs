package ar.com.composehexagonalarchitecture.application.repository

import ar.com.composehexagonalarchitecture.domain.Team
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {
    suspend fun getTeams(): Flow<List<Team>>
}