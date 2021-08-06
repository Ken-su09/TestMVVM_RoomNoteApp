package com.suonk.testmvvm_roomnoteapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suonk.testmvvm_roomnoteapp.databinding.ItemNoteBinding
import com.suonk.testmvvm_roomnoteapp.model.Note

class NoteAdapter(
    private val noteList: List<Note>,
    private val onClickListener: View.OnClickListener
) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private lateinit var itemNoteBinding: ItemNoteBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        itemNoteBinding = ItemNoteBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(itemNoteBinding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: Note = noteList[position]
        holder.bind(note)
        itemNoteBinding.noteCardview.tag = position
        itemNoteBinding.noteCardview.setOnClickListener(onClickListener)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class NoteViewHolder(private val itemNoteBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(itemNoteBinding.root) {
        fun bind(note: Note) {
            itemNoteBinding.noteTitle.text = note.title
            itemNoteBinding.noteContent.text = note.content
        }
    }
}