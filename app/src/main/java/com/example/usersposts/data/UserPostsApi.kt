package com.example.usersposts.data

import com.example.usersposts.data.remoteresponse.UserPostsResponse
import com.example.usersposts.data.remoteresponse.UsersResponse
import retrofit2.http.GET

interface UserPostsApi {

    @GET("/SharminSirajudeen/test_resources/users")
    suspend fun getUsers(): UsersResponse

    @GET("/SharminSirajudeen/test_resources/posts")
    suspend fun getPosts(): UserPostsResponse
}