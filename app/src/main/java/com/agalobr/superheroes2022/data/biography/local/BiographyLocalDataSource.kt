package com.agalobr.superheroes2022.data.biography.local

import com.agalobr.superheroes2022.domain.Biography

interface BiographyLocalDataSource {
    fun save(heroId: Int, biography: Biography)
    fun getBiography(heroId: Int): Biography?
}