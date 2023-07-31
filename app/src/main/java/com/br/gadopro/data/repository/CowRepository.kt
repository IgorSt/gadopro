package com.br.gadopro.data.repository

import com.br.gadopro.data.model.Cow

interface CowRepository {
    suspend fun insertCow(cow: Cow)
}