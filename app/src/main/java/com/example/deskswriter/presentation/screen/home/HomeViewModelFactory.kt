package com.example.deskswriter.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.desks_writer.domain.usecase.AddFileUseCase
import com.desks_writer.domain.usecase.GetFileUseCase

class HomeViewModelFactory(
    private val getFileUseCase: GetFileUseCase,
    private val addFileUseCase: AddFileUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(getFileUseCase, addFileUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}