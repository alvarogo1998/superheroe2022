package com.agalobr.superheroes2022.data.connections

import com.agalobr.superheroes2022.data.connections.local.ConnectionsLocalDataSource
import com.agalobr.superheroes2022.data.connections.remote.ConnectionsRemoteDataSource
import com.agalobr.superheroes2022.domain.Connections
import com.agalobr.superheroes2022.domain.ConnectionsRepository

class ConnectionsDataRepository (
    val localDataSource: ConnectionsLocalDataSource,
    val remoteDataSource: ConnectionsRemoteDataSource
) :
    ConnectionsRepository {

    override fun getConnections(superHeroId: Int): Connections {
        var connections = localDataSource.findByHeroId(superHeroId)
        if (connections == null) {
            connections = remoteDataSource.getConnections(superHeroId)
            localDataSource.save(superHeroId, connections)
        }
        return connections
    }
}