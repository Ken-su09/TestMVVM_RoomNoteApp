package com.suonk.testmvvm_roomnoteapp.viewmodel

import androidx.lifecycle.ViewModel
import com.suonk.testmvvm_roomnoteapp.model.Note
import com.suonk.testmvvm_roomnoteapp.repositories.NoteDataRepository

class NoteViewModel(private val noteDataRepository: NoteDataRepository) : ViewModel() {
    fun getAllNotes() = noteDataRepository.getAllNotes()
    fun getNoteById(noteId: Int) = noteDataRepository.getNote(noteId)
    fun addNote(note: Note) = noteDataRepository.addNote(note)
    fun updateNote(note: Note) = noteDataRepository.updateNote(note)
}