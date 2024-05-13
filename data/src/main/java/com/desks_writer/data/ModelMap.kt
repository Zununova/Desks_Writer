package com.desks_writer.data

import com.desks_writer.data.room.models.FileModelDto
import com.desks_writer.domain.medels.FileModel

fun FileModelDto.toDomain() = FileModel(title, description, data)
fun FileModel.toData() = FileModelDto(title, description, data)