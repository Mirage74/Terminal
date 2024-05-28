package com.balex.terminal.di

import com.balex.terminal.data.network.ApiFactory
import com.balex.terminal.data.network.ApiService
import com.balex.terminal.data.repository.TerminalRepositoryImpl
import com.balex.terminal.domain.repository.TerminalRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: TerminalRepositoryImpl): TerminalRepository


    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}