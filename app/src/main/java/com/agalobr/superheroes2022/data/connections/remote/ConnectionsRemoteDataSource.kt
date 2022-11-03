package com.agalobr.superheroes2022.data.connections.remote

import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.domain.Connections

class ConnectionsRemoteDataSource(val apiClient: ApiClient) {

    fun getConnections(superHeroId: Int): Connections {
        val connections = apiClient.getConnections(superHeroId)!!
        return connections.toDomain()
    }
}