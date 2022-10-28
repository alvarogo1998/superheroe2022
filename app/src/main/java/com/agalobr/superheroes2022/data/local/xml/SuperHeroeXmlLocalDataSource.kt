package com.agalobr.superheroes2022.data.local.xml

import android.content.SharedPreferences
import com.agalobr.superheroes2022.data.local.LocalDataSource
import com.agalobr.superheroes2022.domain.SuperHeroe
import com.google.gson.Gson

class SuperHeroeXmlLocalDataSource(val sharedPreferences: SharedPreferences) : LocalDataSource {

    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    override fun save(superHeroe: List<SuperHeroe>) {
        superHeroe.forEach { superHeroe ->
            editor.putString(superHeroe.id.toString(),gson.toJson(superHeroe))
            editor.apply()
        }
    }
}