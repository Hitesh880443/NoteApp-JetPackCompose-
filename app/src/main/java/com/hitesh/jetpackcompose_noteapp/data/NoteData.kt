package com.hitesh.jetpackcompose_noteapp.data

import com.hitesh.jetpackcompose_noteapp.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A Movie Day", description = "A Movie Day Description"),
            Note(title = "B Movie Day", description = "B Movie Day Description"),
            Note(title = "C Movie Day", description = "C Movie Day Description"),
            Note(title = "A Movie Day", description = "A Movie Day Description"),
            Note(title = "B Movie Day", description = "B Movie Day Description"),
            Note(title = "C Movie Day", description = "C Movie Day Description"),
            Note(title = "A Movie Day", description = "A Movie Day Description"),
            Note(title = "B Movie Day", description = "B Movie Day Description"),
            Note(title = "C Movie Day", description = "C Movie Day Description"),
            Note(title = "A Movie Day", description = "A Movie Day Description"),
            Note(title = "B Movie Day", description = "B Movie Day Description"),
            Note(title = "C Movie Day", description = "C Movie Day Description"),
            Note(title = "A Movie Day", description = "A Movie Day Description"),
            Note(title = "B Movie Day", description = "B Movie Day Description"),
            Note(title = "C Movie Day", description = "C Movie Day Description"),
            Note(title = "D Movie Day", description = "D Movie Day Description")
        )
    }
}