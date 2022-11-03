package com.agalobr.superheroes2022.data.work.local.mem

import com.agalobr.superheroes2022.data.work.local.WorkLocalDataSource
import com.agalobr.superheroes2022.domain.Work

class WorkMemLocalDataSource : WorkLocalDataSource {

    private val dataStore: MutableMap<Int, Work> = mutableMapOf()

    override fun save(heroId: Int, work: Work) {
        dataStore.put(heroId, work)
    }

    override fun getWork(heroId: Int): Work? {
        return dataStore[heroId]
    }
}