package com.example.roomautomigration

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.roomautomigration.db.Student
import com.example.roomautomigration.db.StudentDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val dao = StudentDatabase.getInstance(application).subscriberDAO

        val nameEditText = findViewById<EditText>(R.id.etName)
        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val button = findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener {
            lifecycleScope.launch {
                nameEditText.text.let {
                    dao.insertStudent(Student(0,it.toString(), emailEditText.text.toString()))
                    nameEditText.setText("")
                    emailEditText.setText("")
                    nameEditText.requestFocus()
                }
            }
        }
    }
}