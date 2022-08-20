package com.example.usersposts.di

import com.example.usersposts.ui.Router
import com.example.usersposts.ui.RouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
object RouterModule {

    @ActivityRetainedScoped
    @Provides
    fun providesRouter(): Router {
        return RouterImpl()
    }
}