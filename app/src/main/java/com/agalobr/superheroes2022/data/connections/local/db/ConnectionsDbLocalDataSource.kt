package com.agalobr.superheroes2022.data.connections.local.db

import com.agalobr.superheroes2022.data.connections.local.ConnectionsLocalDataSource
import com.agalobr.superheroes2022.domain.Connections

class ConnectionsDbLocalDataSource (private val dao: ConnectionsDao) : ConnectionsLocalDataSource {

    override fun findByHeroId(heroId: Int): Connections? {
        return dao.findById(heroId)?.toDomain()
    }

    override fun save(heroId: Int, connections: Connections) {
        dao.save(connections.toEntity(heroId))
    }
}