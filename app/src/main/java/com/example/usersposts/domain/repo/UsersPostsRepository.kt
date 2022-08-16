package com.example.usersposts.domain.repo

import com.example.usersposts.data.remoteresponse.UserPostsResponse
import com.example.usersposts.data.remoteresponse.UsersResponse

interface UsersPostsRepository {

   suspend fun getUsers(): UsersResponse

   suspend fun getPosts(): UserPostsResponse
}