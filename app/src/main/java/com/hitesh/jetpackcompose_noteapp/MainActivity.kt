package com.hitesh.jetpackcompose_noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hitesh.jetpackcompose_noteapp.data.NoteDataSource
import com.hitesh.jetpackcompose_noteapp.screen.NoteScreen
import com.hitesh.jetpackcompose_noteapp.ui.theme.JetpackComposeNoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NoteScreen(
                        noteList = NoteDataSource().loadNotes(),
                        addNote = {},
                        removeNote = {}
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeNoteAppTheme {
        NoteScreen(
            noteList = emptyList(),
            addNote = {},
            removeNote = {}
        )

    }
}