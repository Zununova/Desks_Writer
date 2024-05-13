package com.example.deskswriter.di

import com.desks_writer.domain.repository.FileRepository
import com.desks_writer.domain.usecase.AddFileUseCase
import com.desks_writer.domain.usecase.GetFileUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetFilesUseCase(fileRepository: FileRepository) : GetFileUseCase {
        return GetFileUseCase(fileRepository)
    }

    @Provides
    fun provideAddFileUseCase(fileRepository: FileRepository) : AddFileUseCase {
        return AddFileUseCase(fileRepository)
    }
}