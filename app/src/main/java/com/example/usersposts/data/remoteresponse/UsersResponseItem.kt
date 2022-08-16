package com.example.usersposts.data.remoteresponse

data class UsersResponseItem(
    val albumId: Int,
    val name: String,
    val thumbnailUrl: String,
    val url: String,
    val userId: Int
)