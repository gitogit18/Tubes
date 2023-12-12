package com.example.tubes.ui.notessqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notessqlite.NotesDatabaseHelper
import com.example.tubes.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener(){
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show()
        }
    }

}
