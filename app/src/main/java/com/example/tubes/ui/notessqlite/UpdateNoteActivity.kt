package com.example.tubes.ui.notessqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notessqlite.NotesDatabaseHelper
import com.example.tubes.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: NotesDatabaseHelper
    private var noteId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1) {
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.updateTitleEditText.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener {
            val title = binding.updateTitleEditText.text.toString()
            val content = binding.updateContentEditText.text.toString()
            val updatedNote = Note(noteId, title, content)
            db.updateNote (updatedNote)
            finish()
            Toast.makeText(this, "Note updated successfully", Toast.LENGTH_SHORT).show()
        }


    }
}