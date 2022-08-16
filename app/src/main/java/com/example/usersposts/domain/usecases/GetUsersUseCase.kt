package com.example.usersposts.domain.usecases

import com.example.usersposts.common.Resource
import com.example.usersposts.data.remoteresponse.UsersResponse
import com.example.usersposts.domain.repo.UsersPostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: UsersPostsRepository) {

    operator fun invoke(): Flow<Resource<UsersResponse>> = flow{
        try {
            emit(Resource.Loading())
            val usersResponse = repository.getUsers()
            emit(Resource.Success<UsersResponse>(usersResponse))
        } catch(e: HttpException) {
            emit(Resource.Error<UsersResponse>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<UsersResponse>("Couldn't reach server. Check your internet connection."))
        }
    }

}