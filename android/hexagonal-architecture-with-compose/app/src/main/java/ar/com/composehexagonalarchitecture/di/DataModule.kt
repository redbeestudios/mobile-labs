package ar.com.composehexagonalarchitecture.di

import ar.com.composehexagonalarchitecture.application.repository.ITeamRepository
import ar.com.composehexagonalarchitecture.application.repository.IUserRepository
import ar.com.composehexagonalarchitecture.data.network.datasource.TeamsEndpoint
import ar.com.composehexagonalarchitecture.data.network.datasource.UsersEndpoint
import ar.com.composehexagonalarchitecture.data.network.repository.TeamRepository
import ar.com.composehexagonalarchitecture.data.network.repository.UserRepository
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
object DataModule {

    private const val PROVIDE_RETROFIT_USERS_API = "provideRetrofitUsersAPI"
    private const val PROVIDE_RETROFIT_TEAMS_API = "provideRetrofitTeamsAPI"

    //region retrofit Client
    @Singleton
    @Provides
    @Named(PROVIDE_RETROFIT_USERS_API)
    fun provideRetrofitUsersAPI(): Retrofit {
        return buildRetrofit("https://randomuser.me")
    }

    @Singleton
    @Provides
    @Named(PROVIDE_RETROFIT_TEAMS_API)
    fun provideRetrofitTeamsAPI(): Retrofit {
       return buildRetrofit("https://www.balldontlie.io")
    }
    //endregion


    //region retrofit Services

    @Singleton
    @Provides
    fun provideUsersService(@Named(PROVIDE_RETROFIT_USERS_API) retrofit: Retrofit): UsersEndpoint {
        return retrofit.create(UsersEndpoint::class.java)
    }

    @Singleton
    @Provides
    fun provideTeamsService(@Named(PROVIDE_RETROFIT_TEAMS_API) retrofit: Retrofit): TeamsEndpoint {
        return retrofit.create(TeamsEndpoint::class.java)
    }

    //endregion


    //region Repositories
    @Singleton
    @Provides
    fun provideUserRepository(usersService: UsersEndpoint): IUserRepository {
        return UserRepository(usersService)
    }

    @Singleton
    @Provides
    fun provideTeamRepository(teamService: TeamsEndpoint): ITeamRepository {
        return TeamRepository(teamService)
    }

    //endregion


    private fun buildRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()) //TODO: MOSHI
            .build()
        //TODO: Ver de agregar un client e interceptor
    }

}