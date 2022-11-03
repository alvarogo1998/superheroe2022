package com.agalobr.superheroes2022.data.superheroe.remote

import com.agalobr.superheroes2022.domain.SuperHero


fun SuperHeroApiModel.toDomain(): SuperHero {
    return SuperHero(
        this.id, this.name, listOf(
            this.images.xs, this.images.sm, this.images.md, this.images.lg
        )
    )
}