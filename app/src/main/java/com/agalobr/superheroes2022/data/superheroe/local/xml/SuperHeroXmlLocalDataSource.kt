package com.agalobr.superheroes2022.data.superheroe.local.xml

import android.content.SharedPreferences
import com.agalobr.superheroes2022.data.superheroe.local.SuperHeroLocalDataSource
import com.agalobr.superheroes2022.domain.SuperHero
import com.google.gson.Gson

class SuperHeroXmlLocalDataSource (private val sharedPreferences: SharedPreferences) :
    SuperHeroLocalDataSource {
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    override fun save(superHeros: List<SuperHero>) {
        superHeros.forEach { superHero ->
            editor.putString(superHero.id.toString(), gson.toJson(superHero))
        }
        editor.apply()
    }

    override fun getHeroes(): List<SuperHero> {
        val superHeros: MutableList<SuperHero> = mutableListOf()
        sharedPreferences.all.forEach { map ->
            superHeros.add(gson.fromJson(map.value as String, SuperHero::class.java))
        }
        return superHeros
    }

    override fun getHero(heroId: Int): SuperHero? {
        return sharedPreferences.getString(heroId.toString(), null)?.let {
            gson.fromJson(it, SuperHero::class.java)
        }
    }
}