package com.agalobr.superheroes2022.data.work.remote

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.domain.Work

class WorkRemoteDataSource(private val apiClient: ApiClient) {

    fun getWork(superHeroId: Int): Work? {
        return apiClient.getWork(superHeroId)?.toDomain()
    }
}