package com.agalobr.superheroes2022.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agalobr.superheroes2022.domain.GetSuperHeroFeedUseCase
import com.agalobr.superheroes2022.domain.GetSuperHeroeFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHeroesViewModel (private val getSuperHerosFeed: GetSuperHeroFeedUseCase) : ViewModel() {

    fun loadSuperHeros(superHeroCallback: SuperHeroCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHerosFeed = getSuperHerosFeed.execute()
            withContext(Dispatchers.Main) {
                superHeroCallback.onCall(superHerosFeed)
            }
        }
    }

}