package com.example.cycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private  val studentList:List<StudentItem>):RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return  studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem=studentList[position]
        holder.imgView.setImageResource(currentItem.imageResource)
        holder.tvName.setText(currentItem.name)
        holder.tvProgramme.setText(currentItem.programme)
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imgView:ImageView = itemView.findViewById(R.id.face)
        val tvName:TextView=itemView.findViewById(R.id.tvName)
        val tvProgramme:TextView=itemView.findViewById(R.id.tvProgramme)
    }
}