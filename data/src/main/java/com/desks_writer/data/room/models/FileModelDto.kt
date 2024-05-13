package com.desks_writer.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FileModelDto(
    val title: String,
    val description: String,
    val data: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
