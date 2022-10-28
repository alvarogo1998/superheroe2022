package com.agalobr.superheroes2022.data.superheroe

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.domain.SuperHeroe

class SuperHeroeRemoteDataSource(val apiClient: ApiClient) {

    fun getSuperHeroes(): List<SuperHeroe> {
        val superHeroes = apiClient.getSuperHeroes()
        return superHeroes.map {
            it.toDomain()
        }
    }
}