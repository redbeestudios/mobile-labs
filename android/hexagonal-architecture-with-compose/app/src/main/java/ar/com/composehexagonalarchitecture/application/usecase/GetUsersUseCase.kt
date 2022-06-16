package ar.com.composehexagonalarchitecture.application.usecase

import android.util.Log
import ar.com.composehexagonalarchitecture.application.repository.ITeamRepository
import ar.com.composehexagonalarchitecture.application.repository.IUserRepository
import ar.com.composehexagonalarchitecture.domain.Team
import ar.com.composehexagonalarchitecture.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: IUserRepository,
    private val teamRepository: ITeamRepository,
) {
    suspend fun invoke(): Flow<List<User>> {
         val teamsRange: IntRange = (1..30) //TODO: Sacar afuera en un repositorio externo,

        val users: Flow<List<User>> = emptyFlow()
        val teams: Flow<List<Team>> = teamRepository.getTeams()

        val result: Flow<List<User>> =
            users.zip(teams) { usersList, teamsList ->
            usersList.map { user ->
                val id = teamsRange.random() //TODO: No se generan aleatoriamente.. ver LOG
                Log.d("random-id", id.toString())
                user.copy(favoriteTeam = teamsList.find { team -> team.id == id })
            }
        }
        return result
    }
}