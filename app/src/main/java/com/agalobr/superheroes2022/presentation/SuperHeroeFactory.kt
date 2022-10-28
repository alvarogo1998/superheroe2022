package com.agalobr.superheroes2022.presentation

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.data.biography.BiographyDataRepository
import com.agalobr.superheroes2022.data.biography.BiographyRemoteDataSource
import com.agalobr.superheroes2022.data.superheroe.SuperHeroeDataRepository
import com.agalobr.superheroes2022.data.superheroe.SuperHeroeRemoteDataSource
import com.agalobr.superheroes2022.data.work.WorkDataRepository
import com.agalobr.superheroes2022.data.work.WorkRemoteDataSource
import com.agalobr.superheroes2022.domain.GetSuperHeroeFeedUseCase

class SuperHeroeFactory {

    fun getSuperHeroeUseCase(): GetSuperHeroeFeedUseCase {
        val apiClient = ApiClient()
        return GetSuperHeroeFeedUseCase(
            SuperHeroeDataRepository(SuperHeroeRemoteDataSource(apiClient)),
            BiographyDataRepository(BiographyRemoteDataSource(apiClient)),
            WorkDataRepository(WorkRemoteDataSource(apiClient)),
        )
    }

}