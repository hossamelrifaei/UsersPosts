package com.example.usersposts.presentation.userspostslist

import com.example.usersposts.data.remoteresponse.UsersResponse
import com.example.usersposts.domain.model.UsersModel

data class UsersListState (
    val isLoading: Boolean = false,
    val users: List<UsersModel>? = null,
    val error: String = ""
    )