package com.agalobr.superheroes2022.data

import com.agalobr.superheroes2022.data.biography.BiographyApiModel
import com.agalobr.superheroes2022.data.superheroe.SuperHeroeApiModel
import com.agalobr.superheroes2022.data.work.WorkApiModel
import com.agalobr.superheroes2022.domain.SuperHeroe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints o Servicios para SuperHeroes
 */
interface ApiServices {
    @GET("all.json")
    fun getSuperHeroesFeed(): Call<List<SuperHeroeApiModel>>

    @GET("biography/{heroId}.json")
    fun getBiography(@Path("heroId") heroId: Int): Call<BiographyApiModel>

    @GET("work/{heroId}.json")
    fun getWork(@Path("heroId") heroId: Int): Call<WorkApiModel>
}