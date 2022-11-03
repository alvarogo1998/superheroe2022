package com.agalobr.superheroes2022.data.connections.remote

import com.agalobr.superheroes2022.domain.Connections

fun ConnectionsApiModel.toDomain(): Connections {
    return Connections(this.groupAffiliation)
}