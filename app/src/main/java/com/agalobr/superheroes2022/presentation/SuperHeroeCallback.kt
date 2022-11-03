package com.agalobr.superheroes2022.presentation

import com.agalobr.superheroes2022.domain.GetSuperHeroFeedUseCase

interface SuperHeroeCallback {
    fun onCall(superHerosFeed: List<GetSuperHeroFeedUseCase.SuperHeroFeed>)}