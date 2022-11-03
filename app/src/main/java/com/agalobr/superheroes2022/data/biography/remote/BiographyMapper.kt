package com.agalobr.superheroes2022.data.biography

import com.agalobr.superheroes2022.data.biography.remote.BiographyApiModel
import com.agalobr.superheroes2022.domain.Biography

fun BiographyApiModel.toDomain() = Biography(this.fullName, this.alignment)