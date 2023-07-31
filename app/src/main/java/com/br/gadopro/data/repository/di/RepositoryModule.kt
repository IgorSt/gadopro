package com.br.gadopro.data.repository.di

import com.br.gadopro.data.repository.CowRepository
import com.br.gadopro.data.repository.CowRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Singleton
    @Binds
    fun provideCowRepository(cowRepositoryImpl: CowRepositoryImpl): CowRepository
}