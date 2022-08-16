package com.example.usersposts.data.repo

import com.example.usersposts.data.UserPostsApi
import com.example.usersposts.data.remoteresponse.UserPostsResponse
import com.example.usersposts.data.remoteresponse.UsersResponse
import com.example.usersposts.domain.repo.UsersPostsRepository
import javax.inject.Inject

class UsersPostsRepositoryImpl @Inject constructor(private val api: UserPostsApi) :
    UsersPostsRepository {

    override suspend fun getUsers(): UsersResponse {
        return api.getUsers()
    }

    override suspend fun getPosts(): UserPostsResponse {
        return api.getPosts()
    }

}