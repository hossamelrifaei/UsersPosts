package com.example.usersposts.common

import javax.inject.Inject

class ResourceMapper @Inject constructor() {

    fun findCombinedState(resource1: Resource<*>, resource2: Resource<*>): Resource<*> {
        if (resource1 is Resource.Success && resource2 is Resource.Success) {
            return Resource.Success(null)
        }

        if (resource1 is Resource.Loading || resource2 is Resource.Loading) {
            return Resource.Loading(null)
        }

        if (resource1 is Resource.Error || resource2 is Resource.Error) {
            return Resource.Error(null, null)
        }

        return Resource.Loading(null)
    }
}