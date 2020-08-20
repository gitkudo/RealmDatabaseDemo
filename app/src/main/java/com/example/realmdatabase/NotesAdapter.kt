package com.example.realmdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class NotesAdapter(
    private val notesList: RealmResults<Notes>,
    private val listener: itemClickKudo
) :
    RecyclerView.Adapter<NotesAdapter.NoteHolder>() {
   inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener,View.OnLongClickListener {
        val title = itemView?.findViewById<TextView>(R.id.titleTv)
        val des = itemView?.findViewById<TextView>(R.id.desTv)
        val id = itemView?.findViewById<TextView>(R.id.idTv)

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.itemClick(position)
            }
        }

       override fun onLongClick(v: View?): Boolean {
           val position = adapterPosition
           if (position != RecyclerView.NO_POSITION) {
               listener.itemLongClick(position, id.text as String)
           }
           return false
       }


   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val current = notesList[position]
        holder.id.text = current?.id.toString()
        holder.title.text = current?.title
        holder.des.text = current?.description
    }
}