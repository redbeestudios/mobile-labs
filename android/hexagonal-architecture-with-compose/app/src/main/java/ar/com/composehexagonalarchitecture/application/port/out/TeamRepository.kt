package ar.com.composehexagonalarchitecture.application.port.out

import ar.com.composehexagonalarchitecture.domain.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    suspend fun getTeams(): Flow<List<Team>>
}