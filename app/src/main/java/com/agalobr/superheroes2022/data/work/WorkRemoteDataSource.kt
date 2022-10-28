package com.agalobr.superheroes2022.data.work

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.domain.Work

class WorkRemoteDataSource (private val apiClient: ApiClient) {

    fun getWork(superHeroeId: Int): Work?{
        return apiClient.getWork(superHeroeId)?.toDomain()
    }
}