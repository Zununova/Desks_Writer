package com.example.deskswriter.presentation.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desks_writer.domain.medels.FileModel
import com.desks_writer.domain.usecase.AddFileUseCase
import com.desks_writer.domain.usecase.GetFileUseCase
import kotlinx.coroutines.launch

class HomeViewModel(val getFileUseCase: GetFileUseCase, val addFileUseCase: AddFileUseCase) :
    ViewModel() {

    init {
        viewModelScope.launch {
            getFileUseCase().collect {
                Log.e("list", it.toString() )
            }
        }
    }

    fun getFiles() = getFileUseCase()

    fun addFile(fileModel: FileModel) {
        viewModelScope.launch {
            addFileUseCase(fileModel)
        }
    }
}