package com.agalobr.superheroes2022.data.biography


import com.agalobr.superheroes2022.data.biography.local.BiographyLocalDataSource
import com.agalobr.superheroes2022.data.biography.remote.BiographyRemoteDataSource
import com.agalobr.superheroes2022.domain.Biography
import com.agalobr.superheroes2022.domain.BiographyRepository

class BiographyDataRepository(
    val localDataSource: BiographyLocalDataSource,
    val remoteDataSource: BiographyRemoteDataSource
) :
    BiographyRepository {

    override fun getBiography(superHeroId: Int): Biography {
        var biography = localDataSource.getBiography(superHeroId)
        if (biography == null) {
            biography = remoteDataSource.getBiography(superHeroId)
            if (biography != null) {
                localDataSource.save(superHeroId, biography)
            }
        }
        return biography!!
    }
}