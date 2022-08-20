package com.example.usersposts.home

import androidx.fragment.app.Fragment
import com.example.usersposts.R
import com.example.usersposts.presentation.userspostslist.UsersListFragment
import com.example.usersposts.base.BaseActivity


class MainActivity : BaseActivity() {
    override fun layoutRes(): Int {
       return R.layout.activity_main
    }

    override fun initialScreen(): Fragment {
        return UsersListFragment()
    }

}