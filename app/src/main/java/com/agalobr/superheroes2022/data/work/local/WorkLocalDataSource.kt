package com.agalobr.superheroes2022.data.work.local

import com.agalobr.superheroes2022.domain.Work

interface WorkLocalDataSource {
    fun save(heroId: Int, work: Work)
    fun getWork(heroId: Int): Work?
}