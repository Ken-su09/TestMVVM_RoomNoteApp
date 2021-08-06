package com.suonk.testmvvm_roomnoteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    /**
     *
     */
    @ColumnInfo(name = "title")
    var title: String,

    /**
     *
     */
    @ColumnInfo(name = "content")
    var content: String,

    /**
     *  Id de la note.
     */
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) {

}