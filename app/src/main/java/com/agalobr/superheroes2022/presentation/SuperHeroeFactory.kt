package com.agalobr.superheroes2022.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.agalobr.app.data.local.db.AppDatabase
import com.agalobr.app.data.local.mem.MemDataStore
import com.agalobr.superheroes2022.data.ApiClient
import com.agalobr.superheroes2022.data.biography.BiographyDataRepository
import com.agalobr.superheroes2022.data.biography.local.mem.BiographyMemLocalDataSource
import com.agalobr.superheroes2022.data.biography.remote.BiographyRemoteDataSource
import com.agalobr.superheroes2022.data.connections.ConnectionsDataRepository
import com.agalobr.superheroes2022.data.connections.local.db.ConnectionsDbLocalDataSource
import com.agalobr.superheroes2022.data.connections.remote.ConnectionsRemoteDataSource
import com.agalobr.superheroes2022.data.superheroe.SuperHeroDataRepository
import com.agalobr.superheroes2022.data.superheroe.local.xml.SuperHeroXmlLocalDataSource
import com.agalobr.superheroes2022.data.superheroe.remote.SuperHeroRemoteDataSource
import com.agalobr.superheroes2022.data.work.WorkDataRepository
import com.agalobr.superheroes2022.data.work.local.mem.WorkMemLocalDataSource
import com.agalobr.superheroes2022.data.work.remote.WorkRemoteDataSource
import com.agalobr.superheroes2022.domain.*

class SuperHeroeFactory  {

    fun getSuperHerosViewModel(sharedPreferences: SharedPreferences) =
        SuperHerosViewModel(getSuperHeroUseCase(sharedPreferences))

    private fun getSuperHeroUseCase(sharedPreferences: SharedPreferences): GetSuperHeroFeedUseCase {
        return GetSuperHeroFeedUseCase(
            getSuperHeroRepository(sharedPreferences),
            getBiographyRepository(),
            getWorkRepository(),
        )
    }

    private fun getBiographyRepository(): BiographyRepository {
        return BiographyDataRepository(
            BiographyMemLocalDataSource(DataStoreSingletonPlus.getInstance()),
            BiographyRemoteDataSource(getApiClient())
        )
    }

    private fun getConnectionsRepository(applicationContext: Context): ConnectionsRepository {
        return ConnectionsDataRepository(
            ConnectionsDbLocalDataSource(
                DataBaseSingleton.getInstance(applicationContext).connectionsDao()
            ),
            ConnectionsRemoteDataSource(getApiClient())
        )
    }

    private fun getPowerStatsRepository(sharedPreferences: SharedPreferences): PowerStatsRepository {
        return PowerStatsDataRepository(
            PowerStatsXmlLocalDataSource(sharedPreferences),
            PowerStatsRemoteDataSource(getApiClient())
        )
    }

    fun getSuperHeroRepository(sharedPreferences: SharedPreferences): SuperHeroRepository {
        return SuperHeroDataRepository(
            SuperHeroXmlLocalDataSource(sharedPreferences),
            SuperHeroRemoteDataSource(getApiClient())
        )
    }

    fun getWorkRepository(): WorkRepository {
        return WorkDataRepository(
            WorkMemLocalDataSource(),
            WorkRemoteDataSource(getApiClient())
        )
    }

    private fun getApiClient() = ApiClient()

    object DataBaseSingleton {
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "db-superhero"
                ).build()
            }
            return db!!
        }

    }

    object DataStoreSingleton {
        private val dataStore: MutableMap<Int, Biography> = mutableMapOf()

        fun put(id: Int, biography: Biography) {
            dataStore.put(id, biography)
        }

        fun get(id: Int) = dataStore[id]
    }

    object DataStoreSingletonPlus {
        private var dataStore: MemDataStore<Biography>? = null

        fun getInstance(): MemDataStore<Biography> {
            if (dataStore == null) {
                dataStore = MemDataStore()
            }
            return dataStore!!
        }
    }
}