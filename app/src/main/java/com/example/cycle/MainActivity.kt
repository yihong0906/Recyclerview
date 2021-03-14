package com.example.cycle

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cycle.Data.Student
import com.example.cycle.Data.StudentDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var myStudentList= ArrayList<StudentItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateData()

        val btnAdd:Button=findViewById(R.id.add)

        btnAdd.setOnClickListener(){
            val newRec: Student = Student(0,"Yi Hong","RSF")
            CoroutineScope(Dispatchers.IO).launch {
                val dao = StudentDB.getDatabase(application).studentDao()
                dao.addStudent(newRec)

            }
        }

        val btn:Button= findViewById(R.id.btn)

        btn.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {

                val studentDAO = StudentDB.getDatabase(application).studentDao()
                val studentList :Array<Student> = studentDAO.getStudent()

                myStudentList.clear()
                if(studentList!=null)
                {
                    for (student:Student in studentList)
                    {
                        myStudentList.add(StudentItem(R.drawable.ic_face,student.name,student.programme))
                    }
                }


            }

            val recyclerView: RecyclerView =findViewById(R.id.myStudentView)

            recyclerView.adapter = Adapter(myStudentList)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
        }

    }

    fun generateData(){

//        val stud = StudentItem(R.drawable.ic_face,"John","RSF")
////        val stud1 = StudentItem(R.drawable.ic_face,"Ali","RSF")
////        val stud2= StudentItem(R.drawable.ic_face,"Baba","RSF")
////        val stud3 = StudentItem(R.drawable.ic_face,"XD","RSF")
////        val stud4 = StudentItem(R.drawable.ic_face,"IU","RSF")
////        val stud5 = StudentItem(R.drawable.ic_face,"noone","RSF")
//     myStudentList.add(stud)
//        myStudentList.add(stud1)
//        myStudentList.add(stud2)
//        myStudentList.add(stud3)
//        myStudentList.add(stud4)
//        myStudentList.add(stud5)
//        myStudentList.add(stud)
//        myStudentList.add(stud1)
//        myStudentList.add(stud2)
//        myStudentList.add(stud3)
//        myStudentList.add(stud4)
//        myStudentList.add(stud5)

    }
}