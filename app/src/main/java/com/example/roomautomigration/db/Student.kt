package com.example.roomautomigration.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "student_info")
data class Student (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val id : Int,

    @ColumnInfo(name = "student_name")
    var name : String,

    /*@ColumnInfo(name = "student_email", defaultValue = "No Email")
    var email : String,*/

    @ColumnInfo(name = "subject_name")
    var course : String?
)