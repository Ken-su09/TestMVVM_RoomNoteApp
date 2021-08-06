package com.suonk.testmvvm_roomnoteapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    /**
     * Usage:
     * dao.getAllNotes()
     */
    @Query("Select * from note")
    fun getAllNotes(): LiveData<List<Note>>

    /**
     * Usage:
     * dao.getNoteById(noteId)
     */
    @Query("Select * from note WHERE id == :noteId")
    fun getNoteById(noteId: Int): LiveData<Note>

    /**
     * Usage:
     * dao.addNote(note)
     */
    @Insert
    fun addNote(note: Note)

    /**
     * Usage:
     * dao.updateNote(note)
     */
    @Update
    fun updateNote(note: Note)

    /**
     * Usage:
     * dao.deleteNote(note)
     */
    @Delete
    fun deleteNote(note: Note)
}