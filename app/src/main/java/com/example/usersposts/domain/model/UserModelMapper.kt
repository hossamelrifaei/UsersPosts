package com.example.usersposts.domain.model

import com.example.usersposts.data.remoteresponse.UserPostsResponse
import com.example.usersposts.data.remoteresponse.UsersResponse
import com.example.usersposts.data.remoteresponse.UsersResponseItem
import javax.inject.Inject


class UserModelMapper @Inject constructor() {
    fun mapUsersToPosts(users: UsersResponse?, posts: UserPostsResponse?): List<UsersModel> {
        val usersList = mutableListOf<UsersModel>()
        users?.forEach { usersList.add(mapResponseToModel(it, posts)) }
        return usersList
    }

    private fun mapResponseToModel(
        usersResponse: UsersResponseItem,
        userPostsResponse: UserPostsResponse?
    ): UsersModel {
        return UsersModel(
            albumId = usersResponse.albumId,
            name = usersResponse.name,
            thumbnailUrl = usersResponse.thumbnailUrl,
            url = usersResponse.url,
            userId = usersResponse.userId,
            posts = getPostsForUser(usersResponse.userId, userPostsResponse)
        )
    }

    private fun getPostsForUser(
        userId: Int,
        userPostsResponse: UserPostsResponse?
    ): List<UsersModel.Post> {
        val posts = mutableListOf<UsersModel.Post>()
        userPostsResponse?.filter { it.userId == userId }?.forEach {
            posts.add(
                UsersModel.Post(
                    body = it.body,
                    title = it.title,
                    id = it.id,
                    userId = it.userId
                )
            )
        }
        return posts
    }
}