package com.agalobr.superheroes2022.data.work

import com.agalobr.superheroes2022.data.work.local.mem.WorkMemLocalDataSource
import com.agalobr.superheroes2022.data.work.remote.WorkRemoteDataSource
import com.agalobr.superheroes2022.domain.Work
import com.agalobr.superheroes2022.domain.WorkRepository

class WorkDataRepository(
    val localDataSource: WorkMemLocalDataSource, val remoteDataSource: WorkRemoteDataSource
) : WorkRepository {

    override fun getWork(superHeroId: Int): Work {
        var work = localDataSource.getWork(superHeroId)
        if (work == null) {
            work = remoteDataSource.getWork(superHeroId)!! //Siempre devuelve un work
            localDataSource.save(superHeroId, work)
        }
        return work
    }
}