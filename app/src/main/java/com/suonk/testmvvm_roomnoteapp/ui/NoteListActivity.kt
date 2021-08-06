package com.suonk.testmvvm_roomnoteapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.suonk.testmvvm_roomnoteapp.databinding.ActivityNoteListBinding
import com.suonk.testmvvm_roomnoteapp.model.Note
import com.suonk.testmvvm_roomnoteapp.utils.InjectorUtils
import com.suonk.testmvvm_roomnoteapp.viewmodel.NoteViewModel
import com.suonk.testmvvm_roomnoteapp.viewmodel.NoteViewModelFactory

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityNoteListBinding
    private lateinit var notesList: List<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideNoteViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)[NoteViewModel::class.java]

        viewModel.getAllNotes().observe(this, { notes ->
            notesList = notes
            binding.noteRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.noteRecyclerView.adapter = NoteAdapter(notes, this)
        })

        binding.noteDetailButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.tag != null) {
            showNoteDetail(v.tag as Int, notesList)
        } else {
            startActivity(Intent(this@NoteListActivity, NoteDetailActivity::class.java))
        }
    }

    private fun showNoteDetail(position: Int, notesList: List<Note>) {
        startActivity(
            Intent(this@NoteListActivity, NoteDetailActivity::class.java).putExtra(
                "note_id",
                notesList[position].id
            )
        )
    }
}