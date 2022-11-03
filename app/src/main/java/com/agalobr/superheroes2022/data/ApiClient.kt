package com.agalobr.superheroes2022.data

import com.agalobr.superheroes2022.data.biography.remote.BiographyApiModel
import com.agalobr.superheroes2022.data.connections.remote.ConnectionsApiModel
import com.agalobr.superheroes2022.data.superheroe.remote.SuperHeroApiModel
import com.agalobr.superheroes2022.data.work.remote.WorkApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit
 */
class ApiClient {

    private val baseEndPoints: String =
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoints)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    fun getSuperHeroes(): List<SuperHeroApiModel> {
        val superHeroes = apiServices.getSuperHeroesFeed()
        val response = superHeroes.execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getSuperHero(superHeroId: Int): SuperHeroApiModel? {
        val call = apiServices.getSuperHero(superHeroId).execute()
        return call.body()
    }

    fun getBiography(superHeroId: Int): BiographyApiModel? {
        val call = apiServices.getBiography(superHeroId).execute()
        return if (call.isSuccessful) {
            call.body()
        } else {
            null
        }
    }

    fun getWork(superHeroId: Int): WorkApiModel? {
        val call = apiServices.getWork(superHeroId).execute()
        return call.body()
    }

    fun getConnections(superHeroId: Int): ConnectionsApiModel? {
        val call = apiServices.getConnections(superHeroId).execute()
        return call.body()
    }

    fun getPowerStats(superHeroId: Int): PowerStatsApiModel? {
        val call = apiServices.getPowerstats(superHeroId).execute()
        return call.body()
    }
}