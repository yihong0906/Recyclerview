package com.example.cycle.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
    suspend fun addStudent(student: Student)

    @Query(value = "Select * from student_table")
    suspend fun getStudent() :Array<Student>

}