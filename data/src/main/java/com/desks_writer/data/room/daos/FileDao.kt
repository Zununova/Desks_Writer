package com.desks_writer.data.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.desks_writer.data.room.models.FileModelDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FileDao {

    @Query("SELECT * FROM FileModelDto")
    fun getFiles(): Flow<List<FileModelDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFile(fileModelDto: FileModelDto)
}