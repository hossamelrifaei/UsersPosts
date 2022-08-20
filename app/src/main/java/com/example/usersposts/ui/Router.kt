package com.example.usersposts.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.usersposts.domain.model.UsersModel

interface Router {
    fun onCreate(activity: AppCompatActivity, initialScreen: Fragment)
    fun pop(): Boolean
    fun goToDetail(user: UsersModel)
}