package ar.com.composehexagonalarchitecture.application.usecase

import android.util.Log
import ar.com.composehexagonalarchitecture.application.port.out.UserRepository
import ar.com.composehexagonalarchitecture.domain.Team
import ar.com.composehexagonalarchitecture.domain.User
import ar.com.composehexagonalarchitecture.application.port.out.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val teamRepository: TeamRepository,
) {
    suspend fun invoke(): Flow<List<User>> {
         val teamsRange: IntRange = (1..30) //TODO: Sacar afuera en un repositorio externo,

        val users: Flow<List<User>> = userRepository.getUsers()
        val teams: Flow<List<Team>> = teamRepository.getTeams()

        val result: Flow<List<User>> =
            users.zip(teams) { users, teams ->
            users.map { user ->
                val id = teamsRange.random() //TODO: No se generan aleatoriamente.. ver LOG
                Log.d("random-id", id.toString())
                user.copy(favoriteTeam = teams.find { team -> team.id == id })
            }
        }
        return result
    }
}