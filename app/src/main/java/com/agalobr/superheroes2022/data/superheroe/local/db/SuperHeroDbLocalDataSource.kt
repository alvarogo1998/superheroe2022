package com.agalobr.superheroes2022.data.superheroe.local.db

import com.agalobr.superheroes2022.data.superheroe.local.SuperHeroLocalDataSource
import com.agalobr.superheroes2022.domain.SuperHero

class SuperHeroDbLocalDataSource : SuperHeroLocalDataSource {
    override fun save(superHero: List<SuperHero>) {
        TODO("Not yet implemented")
    }

    override fun getHeroes(): List<SuperHero> {
        TODO("Not yet implemented")
    }

    override fun getHero(heroId: Int): SuperHero? {
        TODO("Not yet implemented")
    }
}