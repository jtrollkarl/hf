package com.moducode.hf.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.moducode.hf.R
import com.moducode.hf.data.Program
import com.moducode.hf.toPx
import kotlinx.android.synthetic.main.list_item.view.*

class ProgramsRecyclerAdapter(private val func: (Program) -> Unit): RecyclerView.Adapter<ProgramsRecyclerAdapter.ProgramViewHolder>() {

    lateinit var data: List<Program>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ProgramViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.bind(data[position], func)
    }

    class ProgramViewHolder(val layout: View): RecyclerView.ViewHolder(layout){

        fun bind(program: Program, func: (Program) -> Unit){

            layout.setOnClickListener { func(program) }
            Glide.with(layout.context).apply { RequestOptions().fitCenter().override(300.toPx())}.load(program.programimagetemplate).into(layout.list_station_image)
            layout.list_station_name.text = program.name
        }
    }

}