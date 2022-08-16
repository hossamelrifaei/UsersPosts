package com.example.usersposts.presentation.userspostslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersposts.common.Resource
import com.example.usersposts.common.ResourceMapper
import com.example.usersposts.domain.model.UserModelMapper
import com.example.usersposts.domain.model.UsersModel
import com.example.usersposts.domain.usecases.GetUserPostsUseCase
import com.example.usersposts.domain.usecases.GetUsersUseCase
import com.example.usersposts.ui.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.zip
import javax.inject.Inject


@HiltViewModel
class UsersListViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase,
    getUserPostsUseCase: GetUserPostsUseCase,
    private val userMapper: UserModelMapper,
    private val resourceMapper: ResourceMapper,
    private val router: Router
) : ViewModel() {

    private val _uiState: MutableStateFlow<UsersListState> = MutableStateFlow(UsersListState())
    val uiState: StateFlow<UsersListState> = _uiState

    init {
        getUsersUseCase().zip(getUserPostsUseCase()) { users, posts ->
            when (resourceMapper.findCombinedState(users, posts)) {
                is Resource.Success -> _uiState.value =
                    UsersListState(users = userMapper.mapUsersToPosts(users.data, posts.data))
                is Resource.Loading -> _uiState.value = UsersListState(isLoading = true)
                is Resource.Error -> _uiState.value =
                    UsersListState(error = users.message ?: "An unexpected error occured")
            }
        }.launchIn(viewModelScope)
    }


    fun handleUserClicked(user: UsersModel) = router.goToDetail(user)

}

