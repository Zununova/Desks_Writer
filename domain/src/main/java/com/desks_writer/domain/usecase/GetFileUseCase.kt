package com.desks_writer.domain.usecase

import com.desks_writer.domain.medels.FileModel
import com.desks_writer.domain.repository.FileRepository
import kotlinx.coroutines.flow.Flow

class GetFileUseCase(private val fileRepository: FileRepository) {

    operator fun invoke(): Flow<List<FileModel>> {
        return fileRepository.getFiles()
    }
}