package com.agalobr.superheroes2022.data.superheroe

import com.agalobr.superheroes2022.domain.SuperHeroe
import com.agalobr.superheroes2022.domain.SuperHeroeRepository

class SuperHeroeDataRepository (val remoteSource: SuperHeroeRemoteDataSource) :
    SuperHeroeRepository {

    override fun getSuperHeroe(): List<SuperHeroe> {
        return remoteSource.getSuperHeroes()
    }
}