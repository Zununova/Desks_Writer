package com.example.deskswriter.di

import android.content.Context
import androidx.room.Room
import com.desks_writer.data.repository.FileRepositoryImpl
import com.desks_writer.data.room.CommonDatabase
import com.desks_writer.domain.repository.FileRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule(private val context: Context) {

    @Provides
    fun provideDatabase(): CommonDatabase {
        return Room.databaseBuilder(context, CommonDatabase::class.java, "Database")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideFileRepository(commonDatabase: CommonDatabase): FileRepository {
        return FileRepositoryImpl(commonDatabase.fileDao)
    }
}