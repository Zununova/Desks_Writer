package com.desks_writer.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.desks_writer.data.room.daos.FileDao
import com.desks_writer.data.room.models.FileModelDto

@Database(entities = [FileModelDto::class], version = 4)
abstract class CommonDatabase : RoomDatabase() {
    abstract val fileDao: FileDao
}