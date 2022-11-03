package com.agalobr.superheroes2022.data.connections.local.db

import com.agalobr.superheroes2022.domain.Connections

fun ConnectionsEntity.toDomain(): Connections = Connections(this.groupAffiliation)
fun Connections.toEntity(heroId: Int) = ConnectionsEntity(heroId, this.groupAffiliation)