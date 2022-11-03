package com.agalobr.superheroes2022.data.biography.local.mem

import com.agalobr.app.data.local.mem.MemDataStore
import com.agalobr.superheroes2022.data.biography.local.BiographyLocalDataSource
import com.agalobr.superheroes2022.domain.Biography

class BiographyMemLocalDataSource (private val dataStore: MemDataStore<Biography>) :
    BiographyLocalDataSource {

    override fun save(heroId: Int, biography: Biography) {
        dataStore.put(heroId.toString(), biography)
    }

    override fun getBiography(heroId: Int): Biography? {
        return dataStore.get(heroId.toString())
    }
}