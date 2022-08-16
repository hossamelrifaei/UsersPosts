package com.example.usersposts.presentation.userspostslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.usersposts.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_users_list.progress_circular
import kotlinx.android.synthetic.main.fragment_users_list.tv_error
import kotlinx.android.synthetic.main.fragment_users_list.users_list
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersListFragment : Fragment() {
    private val viewModel by viewModels<UsersListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.uiState
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect { userListState ->
                    userListState.users?.let {
                        progress_circular.hide()
                        users_list.adapter = UsersListAdapter(users = it) {user ->
                            viewModel.handleUserClicked(user)
                        }
                    }
                    if (userListState.isLoading) {
                        progress_circular.show()
                    }
                    if (userListState.error.isNotBlank()) {
                        tv_error.text = userListState.error
                        progress_circular.hide()
                    }
                }
        }
    }
}
