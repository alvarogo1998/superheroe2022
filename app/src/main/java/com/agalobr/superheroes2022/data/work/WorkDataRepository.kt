package com.agalobr.superheroes2022.data.work

import com.agalobr.superheroes2022.domain.Work
import com.agalobr.superheroes2022.domain.WorkRepository

class WorkDataRepository(val remoteDataSource: WorkRemoteDataSource) :
    WorkRepository {

    override fun getWork(superHeroeId: Int): Work {
        return remoteDataSource.getWork(superHeroeId) ?: Work("Programador")
    }
}