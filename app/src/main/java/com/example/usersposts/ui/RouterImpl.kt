package com.example.usersposts.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.usersposts.R
import com.example.usersposts.common.Constants
import com.example.usersposts.domain.model.UsersModel
import com.example.usersposts.presentation.userpostdetail.UserPostsDetailFragment
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class Router @Inject internal constructor() {
    private lateinit var fragmentManager: FragmentManager

    fun onCreate(activity: AppCompatActivity, initialScreen: Fragment) {
        init(activity.supportFragmentManager, initialScreen)
    }

    private fun init(fragmentManager: FragmentManager, rootScreen: Fragment) {
        this.fragmentManager = fragmentManager
        this.fragmentManager
        if (fragmentManager.fragments.size == 0) {
            fragmentManager.beginTransaction()
                .replace(R.id.screen_container, rootScreen)
                .commit()
        }
    }

    fun pop(): Boolean {
        return fragmentManager.popBackStackImmediate()
    }

    fun goToDetail(user: UsersModel) {
        val fragment = UserPostsDetailFragment()
        fragment.arguments = bundleOf(Constants.USER_MODEL to user)
        fragmentManager
            .beginTransaction()
            .replace(R.id.screen_container, fragment)
            .addToBackStack(null)
            .commit()
    }

}