package com.desks_writer.data.repository

import com.desks_writer.data.room.daos.FileDao
import com.desks_writer.data.toData
import com.desks_writer.data.toDomain
import com.desks_writer.domain.medels.FileModel
import com.desks_writer.domain.repository.FileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FileRepositoryImpl(private val fileDao: FileDao) : FileRepository {

    override fun getFiles(): Flow<List<FileModel>> {
        return fileDao.getFiles().map { filesList->
            filesList.map {fileModelDto ->
                fileModelDto.toDomain()
            }
        }
    }

    override suspend fun addFile(fileModel: FileModel) {
        fileDao.addFile(fileModel.toData())
    }
}