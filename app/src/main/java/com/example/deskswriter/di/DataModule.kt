package com.example.deskswriter.di

import android.content.Context
import androidx.room.Room
import com.desks_writer.data.repository.FileRepositoryImpl
import com.desks_writer.data.room.CommonDatabase
import com.desks_writer.domain.repository.FileRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideDatabase(): CommonDatabase {
        return Room.databaseBuilder(context, CommonDatabase::class.java, "Database")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideFileRepository(commonDatabase: CommonDatabase): FileRepository {
        return FileRepositoryImpl(commonDatabase.fileDao)
    }
}