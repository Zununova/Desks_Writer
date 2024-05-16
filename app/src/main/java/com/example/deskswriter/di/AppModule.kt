package com.example.deskswriter.di

import com.desks_writer.domain.usecase.AddFileUseCase
import com.desks_writer.domain.usecase.GetFileUseCase
import com.example.deskswriter.presentation.screen.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideHomeViewModelFactory(
        getFileUseCase: GetFileUseCase,
        addFileUseCase: AddFileUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(getFileUseCase, addFileUseCase)
    }
}