package com.agalobr.superheroes2022.data.connections.local

import com.agalobr.superheroes2022.domain.Connections

interface ConnectionsLocalDataSource {
    fun findByHeroId(heroId: Int): Connections?
    fun save(heroId: Int, connections: Connections)
}