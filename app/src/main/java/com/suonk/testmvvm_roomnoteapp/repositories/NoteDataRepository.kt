package com.suonk.testmvvm_roomnoteapp.repositories

import androidx.lifecycle.LiveData
import com.suonk.testmvvm_roomnoteapp.model.Note
import com.suonk.testmvvm_roomnoteapp.model.NoteDAO

class NoteDataRepository(var noteDAO: NoteDAO) {

    fun getAllNotes(): LiveData<List<Note>> {
        return noteDAO.getAllNotes()
    }

    fun getNote(noteId: Int): LiveData<Note> {
        return noteDAO.getNoteById(noteId)
    }

    fun addNote(note: Note) {
        return noteDAO.addNote(note)
    }

    fun updateNote(note: Note) {
        return noteDAO.updateNote(note)
    }

    companion object {
        @Volatile
        private var instance: NoteDataRepository? = null

        fun getInstance(noteDAO: NoteDAO) = instance ?: synchronized(this) {
            instance ?: NoteDataRepository(noteDAO).also {
                instance = it
            }
        }
    }
}