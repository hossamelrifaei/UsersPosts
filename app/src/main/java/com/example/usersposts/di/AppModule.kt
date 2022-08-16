package com.example.usersposts.di

import com.example.usersposts.common.Constants
import com.example.usersposts.data.UserPostsApi
import com.example.usersposts.data.repo.UsersPostsRepositoryImpl
import com.example.usersposts.domain.repo.UsersPostsRepository
import com.example.usersposts.ui.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): UserPostsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserPostsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersPostsRepository(api: UserPostsApi): UsersPostsRepository {
        return UsersPostsRepositoryImpl(api)
    }

}