package com.suonk.testmvvm_roomnoteapp.utils

import com.suonk.testmvvm_roomnoteapp.model.App
import com.suonk.testmvvm_roomnoteapp.repositories.NoteDataRepository
import com.suonk.testmvvm_roomnoteapp.viewmodel.NoteViewModelFactory

object InjectorUtils {
    fun provideNoteViewModelFactory(): NoteViewModelFactory {
        val noteDataRepository = NoteDataRepository.getInstance(App.database.noteDao())
        return NoteViewModelFactory(noteDataRepository)
    }
}