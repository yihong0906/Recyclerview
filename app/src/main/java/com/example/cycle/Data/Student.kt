package com.example.cycle.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student_table")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val ImageResource:Int,
    val name:String,
    val programme:String
)