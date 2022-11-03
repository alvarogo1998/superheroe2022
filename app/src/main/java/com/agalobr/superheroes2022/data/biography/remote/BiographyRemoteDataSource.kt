package com.agalobr.superheroes2022.data.biography.remote

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.data.biography.toDomain
import com.agalobr.superheroes2022.domain.Biography

class BiographyRemoteDataSource(private val apiClient: ApiClient) {

    fun getBiography(superHeroId: Int): Biography? =
        apiClient.getBiography(superHeroId)?.toDomain()
}