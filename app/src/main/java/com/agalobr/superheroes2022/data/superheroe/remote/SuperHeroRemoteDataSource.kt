package com.agalobr.superheroes2022.data.superheroe.remote

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.domain.SuperHero


class SuperHeroRemoteDataSource(val apiClient: ApiClient) {

    fun getSuperHeroes(): List<SuperHero> {
        val superHeros = apiClient.getSuperHeroes().subList(0, 15)
        return superHeros.map {
            it.toDomain()
        }
    }

    fun getSuperHero(superHeroId: Int): SuperHero? {
        return apiClient.getSuperHero(superHeroId)?.toDomain()
    }
}