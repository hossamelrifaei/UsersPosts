package com.example.usersposts.domain.usecases

import com.example.usersposts.common.Resource
import com.example.usersposts.data.remoteresponse.UserPostsResponse
import com.example.usersposts.data.remoteresponse.UsersResponse
import com.example.usersposts.domain.repo.UsersPostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserPostsUseCase @Inject constructor(private val repository: UsersPostsRepository) {

    operator fun invoke(): Flow<Resource<UserPostsResponse>> = flow{
        try {
            emit(Resource.Loading())
            val userPostsResponse = repository.getPosts()
            emit(Resource.Success<UserPostsResponse>(userPostsResponse))
        } catch(e: HttpException) {
            emit(Resource.Error<UserPostsResponse>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<UserPostsResponse>("Couldn't reach server. Check your internet connection."))
        }
    }

}