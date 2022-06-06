package ar.com.composehexagonalarchitecture.data.network.adapter

import android.util.Log
import ar.com.composehexagonalarchitecture.data.network.mapper.TeamMapper
import ar.com.composehexagonalarchitecture.data.network.service.TeamsService
import ar.com.composehexagonalarchitecture.domain.Team
import ar.com.composehexagonalarchitecture.application.port.out.TeamRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class TeamAdapter @Inject constructor(private val teamsService: TeamsService) : TeamRepository { //TODO: No se deberian llamar adapters.. en android es otra cosa
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getTeams(): Flow<List<Team>> {

        return flow {
                val teams = teamsService.getTeams().body()!!
                    .data//TODO: Ver
                    .onEach { Log.d("response-teams", it.toString()) }
                    .map { teamRest -> TeamMapper.toDomain(teamRest)}
                    .onEach { Log.d("response-teams-map", it.toString()) }
                emit(teams)

            }.catch { throw Exception(it.message) } //TODO: Manejar error
            .flowOn(dispatcher)
/*
        return flow<List<Team>> {
            emit(listOf())
        }.flowOn(dispatcher)*/

        }
}