package ar.com.composehexagonalarchitecture.di

import ar.com.composehexagonalarchitecture.application.port.out.TeamRepository
import ar.com.composehexagonalarchitecture.application.port.out.UserRepository
import ar.com.composehexagonalarchitecture.data.network.adapter.TeamAdapter
import ar.com.composehexagonalarchitecture.data.network.adapter.UserAdapter
import ar.com.composehexagonalarchitecture.data.network.service.TeamsService
import ar.com.composehexagonalarchitecture.data.network.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val PROVIDE_RETROFIT_USERS_API = "provideRetrofitUsersAPI"
    private const val PRORIVDE_RETROFIT_TEAMS_API = "provideRetrofitTeamsAPI"

    //region retrofit Client
    @Singleton
    @Provides
    @Named(PROVIDE_RETROFIT_USERS_API)
    fun provideRetrofitUsersAPI(): Retrofit {
        return buildRetrofit("https://randomuser.me")
    }

    @Singleton
    @Provides
    @Named(PRORIVDE_RETROFIT_TEAMS_API)
    fun provideRetrofitTeamsAPI(): Retrofit {
       return buildRetrofit("https://www.balldontlie.io")
    }
    //endregion


    //region retrofit Services

    @Singleton
    @Provides
    fun provideUsersService(@Named(PROVIDE_RETROFIT_USERS_API) retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Singleton
    @Provides
    fun provideTeamsService(@Named(PRORIVDE_RETROFIT_TEAMS_API) retrofit: Retrofit): TeamsService {
        return retrofit.create(TeamsService::class.java)
    }

    //endregion


    //region Repositories
    @Singleton
    @Provides
    fun provideUserRepository(usersService: UsersService): UserRepository {
        return UserAdapter(usersService)
    }

    @Singleton
    @Provides
    fun provideTeamRepository(teamService: TeamsService): TeamRepository {
        return TeamAdapter(teamService)
    }

    //endregion


    private fun buildRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //TODO: Ver de agregar un client e interceptor
    }

}