package com.desks_writer.domain.usecase

import com.desks_writer.domain.medels.FileModel
import com.desks_writer.domain.repository.FileRepository

class AddFileUseCase(private val fileRepository: FileRepository) {

    suspend operator fun invoke(fileModel: FileModel) {
        fileRepository.addFile(fileModel)
    }
}