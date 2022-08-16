package com.example.usersposts.data.remoteresponse

import com.example.usersposts.domain.model.UsersModel

data class UserPostsResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)