package com.br.gadopro.data.repository

import androidx.annotation.WorkerThread
import com.br.gadopro.data.dao.CowDao
import com.br.gadopro.data.model.Cow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CowRepositoryImpl @Inject constructor(
    private val cowDao: CowDao
): CowRepository {

    val allCows: Flow<List<Cow>> = cowDao.getAllCows()

    @WorkerThread
    override suspend fun insertCow(cow: Cow) {
        cowDao.insertNewCow(cow)
    }
}