package com.hitesh.jetpackcompose_noteapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitesh.jetpackcompose_noteapp.R
import com.hitesh.jetpackcompose_noteapp.components.NotesButton
import com.hitesh.jetpackcompose_noteapp.components.NotesInputField
import com.hitesh.jetpackcompose_noteapp.data.NoteDataSource
import com.hitesh.jetpackcompose_noteapp.model.Note

@Composable
fun NoteScreen(
    noteList: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit,
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        TopAppBar {
            Text(text = stringResource(id = R.string.app_name))
        }
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NotesInputField(text = title,
                label = stringResource(id = R.string.title_label),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                onTextChange = {
                    title = it
                })

            NotesInputField(text = description,
                label = stringResource(id = R.string.note_label),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                maxLine = 3,
                onTextChange = {
                    description = it
                })

            NotesButton(label = "Save", onClick = {
                if (!title.isNullOrEmpty() && !description.isNullOrEmpty()) {
                    verifyAndSaveNotes(title, description)
                    title = ""
                    description = ""
                }
            })


            Divider(modifier = Modifier.padding(vertical = 10.dp))

            LazyColumn {
                items(noteList) { note ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)) {
                        Column(
                            modifier = Modifier
                                .background(Color(0xFFC2C2C2))
                                .padding(8.dp)
                        ) {
                            Text(text = note.title,
                                style = MaterialTheme.typography.subtitle2
                            )
                            Text(text = note.description,
                                modifier = Modifier.padding(top = 4.dp),
                                style = MaterialTheme.typography.body2)
                        }
                    }

                }
            }
        }


    })
}

fun verifyAndSaveNotes(title: String, description: String) {
    Note(title = title, description = description)
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        noteList = NoteDataSource().loadNotes(),
        addNote = {},
        removeNote = {}
    )
}