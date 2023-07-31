package com.br.gadopro

import android.content.Context
import androidx.room.Room
import com.br.gadopro.data.dao.CowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(gadoProDatabase: GadoProDatabase): CowDao {
        return gadoProDatabase.cowDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): GadoProDatabase {
        return Room.databaseBuilder(
            appContext,
            GadoProDatabase::class.java,
            "gadopro_database"
        ).build()
    }
}