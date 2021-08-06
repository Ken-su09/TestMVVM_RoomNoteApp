package com.suonk.testmvvm_roomnoteapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.suonk.testmvvm_roomnoteapp.R
import com.suonk.testmvvm_roomnoteapp.databinding.ActivityNoteDetailBinding
import com.suonk.testmvvm_roomnoteapp.databinding.ActivityNoteListBinding
import com.suonk.testmvvm_roomnoteapp.model.Note
import com.suonk.testmvvm_roomnoteapp.utils.InjectorUtils
import com.suonk.testmvvm_roomnoteapp.viewmodel.NoteViewModel
import com.suonk.testmvvm_roomnoteapp.viewmodel.NoteViewModelFactory

class NoteDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteDetailBinding
    private lateinit var viewModel: NoteViewModel
    private lateinit var factory: NoteViewModelFactory

    private lateinit var note: Note
    private var noteId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeUI()
    }

    private fun initializeUI() {
        factory = InjectorUtils.provideNoteViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[NoteViewModel::class.java]

        getNoteWithIntent()

        binding.noteButton.setOnClickListener {
            if (noteId == 0) {
                note =
                    Note(
                        binding.noteTitleEdit.text.toString(),
                        binding.noteContentEdit.text.toString()
                    )

                viewModel.addNote(note)
            } else {
                note.title = binding.noteTitleEdit.text.toString()
                note.content = binding.noteContentEdit.text.toString()
                viewModel.updateNote(note)
            }
            startActivity(Intent(this@NoteDetailActivity, NoteListActivity::class.java))
            finish()
        }
    }

    private fun getNoteWithIntent() {
        noteId = intent.getIntExtra("note_id", 0)
        if (noteId != 0) {
            viewModel.getNoteById(noteId).observe(this, { note ->
                this.note = note
                binding.noteTitleEdit.setText(note.title)
                binding.noteContentEdit.setText(note.content)
            })
        }
    }
}