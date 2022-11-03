package com.agalobr.superheroes2022.data.superheroe.local

import com.agalobr.superheroes2022.domain.SuperHero

interface SuperHeroLocalDataSource {
    fun save(superHeros: List<SuperHero>)
    fun getHeroes(): List<SuperHero>
    fun getHero(heroId: Int): SuperHero?
}