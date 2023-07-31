package com.br.gadopro.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.gadopro.data.model.Cow
import kotlinx.coroutines.flow.Flow

@Dao
interface CowDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewCow(cow: Cow)

    @Query("DELETE FROM cows")
    fun deleteCow()

    @Query("SELECT * FROM cows")
    fun getAllCows(): Flow<List<Cow>>
}