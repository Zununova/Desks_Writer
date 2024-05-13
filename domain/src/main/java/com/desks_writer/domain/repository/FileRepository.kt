package com.desks_writer.domain.repository

import com.desks_writer.domain.medels.FileModel
import kotlinx.coroutines.flow.Flow

interface FileRepository {

    fun getFiles() : Flow<List<FileModel>>
    suspend fun addFile(fileModel: FileModel)
}