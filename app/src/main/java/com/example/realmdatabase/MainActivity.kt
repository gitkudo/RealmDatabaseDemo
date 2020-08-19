package com.example.realmdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), itemClickKudo {
    lateinit var realm: Realm
    lateinit var notesRcv: RecyclerView
    lateinit var notList: ArrayList<Notes>
    var manager = DataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        notesRcv = findViewById(R.id.recyclerView)
        notesRcv.layoutManager = GridLayoutManager(this, 2)
        fab.setOnClickListener {
            startActivity(Intent(this, AddNoteAct::class.java))
            finish()
        }
        getAllNotes()

    }

    private fun getAllNotes() {
        notList = ArrayList()
        notList.clear()
        val result: RealmResults<Notes> = realm.where<Notes>(Notes::class.java).findAll()
        notesRcv.adapter = NotesAdapter(result, this)
        notesRcv.adapter!!.notifyDataSetChanged()
    }

    override fun itemClick(position: Int) {
        val result: RealmResults<Notes> = realm.where<Notes>(Notes::class.java).findAll()
        manager.delNote(realm, result[position]?.id)
        notesRcv.adapter!!.notifyDataSetChanged()
    }

    override fun itemLongClick(position: Int) {
        val result: RealmResults<Notes> = realm.where<Notes>(Notes::class.java).findAll()
        var intent = Intent(this, EditAct::class.java)
        intent.putExtra("obPosition",result[position]?.id)
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()
        notesRcv.adapter!!.notifyDataSetChanged()
    }

}