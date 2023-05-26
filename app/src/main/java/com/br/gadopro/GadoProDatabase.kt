package com.br.gadopro

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.br.gadopro.data.dao.CowDao
import com.br.gadopro.data.model.Cow

@Database(entities = [Cow::class], version = 1, exportSchema = false)
public abstract class GadoProDatabase : RoomDatabase() {

    abstract fun cowDao(): CowDao

    companion object {
        @Volatile
        private var INSTANCE: GadoProDatabase? = null

        fun getDatabase(context: Context): GadoProDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GadoProDatabase::class.java,
                    "gadopro_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}