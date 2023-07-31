package com.br.gadopro

import androidx.room.Database
import androidx.room.RoomDatabase
import com.br.gadopro.data.dao.CowDao
import com.br.gadopro.data.model.Cow

@Database(entities = [Cow::class], version = 1, exportSchema = false)
abstract class GadoProDatabase : RoomDatabase() {

    abstract fun cowDao(): CowDao
}