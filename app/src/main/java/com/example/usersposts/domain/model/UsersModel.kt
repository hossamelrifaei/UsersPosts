package com.example.usersposts.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersModel(
    val albumId: Int,
    val name: String,
    val thumbnailUrl: String,
    val url: String,
    val userId: Int,
    val posts: List<Post>
) : Parcelable {
    @Parcelize
    data class Post(
        val body: String,
        val id: Int,
        val title: String,
        val userId: Int
    ) : Parcelable
}




