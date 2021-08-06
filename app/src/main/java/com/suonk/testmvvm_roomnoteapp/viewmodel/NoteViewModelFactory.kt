package com.suonk.testmvvm_roomnoteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suonk.testmvvm_roomnoteapp.repositories.NoteDataRepository

class NoteViewModelFactory(private val noteDataRepository: NoteDataRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteDataRepository) as T
    }
}