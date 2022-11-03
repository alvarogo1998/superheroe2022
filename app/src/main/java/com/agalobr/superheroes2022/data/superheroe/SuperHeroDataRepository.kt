package com.agalobr.superheroes2022.data.superheroe

import com.agalobr.superheroes2022.data.superheroe.local.SuperHeroLocalDataSource
import com.agalobr.superheroes2022.data.superheroe.remote.SuperHeroRemoteDataSource
import com.agalobr.superheroes2022.domain.SuperHero
import com.agalobr.superheroes2022.domain.SuperHeroRepository

class SuperHeroDataRepository (
    val localSource: SuperHeroLocalDataSource,
    val remoteSource: SuperHeroRemoteDataSource
) :
    SuperHeroRepository {

    override fun getSuperHero(): List<SuperHero> {
        var superHeroes = localSource.getHeroes()
        if (superHeroes.isEmpty()) {
            superHeroes = remoteSource.getSuperHeroes()
            if (superHeroes.isNotEmpty()) {
                localSource.save(superHeroes)
            }
        }
        return superHeroes
    }

    override fun getSuperHeroById(superHeroId: Int): SuperHero? {
        //return localSource.getHero(superHeroId) ?: remoteSource.getSuperHero(superHeroId)
        var hero = localSource.getHero(superHeroId)
        if (hero == null) {
            hero = remoteSource.getSuperHero(superHeroId)
        }
        return hero
    }
}