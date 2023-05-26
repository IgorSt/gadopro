package com.br.gadopro.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.br.gadopro.data.model.Cow

@Dao
interface CowDao {

    @Insert
    fun insertNewCow(cow: Cow)

    @Delete
    fun deleteCow(cow: Cow)

    @Query("SELECT * FROM cows")
    fun getAllCows(): List<Cow>
}