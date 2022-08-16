package com.example.usersposts.presentation.userpostdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.usersposts.common.Constants
import com.example.usersposts.domain.model.UsersModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserPostsDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) :
    ViewModel() {

    private val _state = MutableLiveData<UsersModel>()
    val state: LiveData<UsersModel> = _state

    init {
        savedStateHandle.get<UsersModel>(Constants.USER_MODEL)?.let { user ->
            _state.value = user
        }
    }
}