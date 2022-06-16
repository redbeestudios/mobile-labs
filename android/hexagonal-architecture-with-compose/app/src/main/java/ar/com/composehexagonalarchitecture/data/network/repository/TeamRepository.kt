package ar.com.composehexagonalarchitecture.data.network.repository

import android.util.Log
import ar.com.composehexagonalarchitecture.data.network.mapper.TeamMapper
import ar.com.composehexagonalarchitecture.data.network.datasource.TeamsEndpoint
import ar.com.composehexagonalarchitecture.domain.Team
import ar.com.composehexagonalarchitecture.application.repository.ITeamRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class TeamRepository @Inject constructor(private val teamsEndpoint: TeamsEndpoint) : ITeamRepository {
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getTeams(): Flow<List<Team>> {

        return flow {
                val teams = teamsEndpoint.getTeams().body()!!
                    .data//TODO: Ver
                    .onEach { Log.d("response-teams", it.toString()) }
                    .map { teamRest -> TeamMapper.toDomain(teamRest)}
                    .onEach { Log.d("response-teams-map", it.toString()) }
                emit(teams)

            }.catch { throw Exception(it.message) } //TODO: Manejar error
            .flowOn(dispatcher)
        }
}