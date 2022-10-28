package com.agalobr.superheroes2022.data.biography

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.domain.Biography

class BiographyRemoteDataSource(private val apiClient: ApiClient) {

    fun getBiography(superHeroeId: Int): Biography? =
        apiClient.getBiography(superHeroeId)?.toDomain()
}