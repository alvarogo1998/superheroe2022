package com.agalobr.superheroes2022.data.biography


import com.agalobr.superheroes2022.domain.Biography
import com.agalobr.superheroes2022.domain.BiographyRepository

class BiographyDataRepository (val remoteDataSource: BiographyRemoteDataSource) :
    BiographyRepository {

    override fun getBiography(superHeroeId: Int): Biography {
        return remoteDataSource.getBiography(superHeroeId) ?: Biography("test")
    }
}