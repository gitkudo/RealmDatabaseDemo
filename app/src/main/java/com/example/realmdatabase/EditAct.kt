package com.example.realmdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_edit.*

class EditAct : AppCompatActivity() {
    lateinit var realm: Realm
    var manager = DataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        realm = Realm.getDefaultInstance()
        val item = intent.getParcelableExtra<Notes>("objUpdate")


        btn_edit.setOnClickListener {
//            notes = realm.where(Notes::class.java)
//                .equalTo("id", position)
//                .findFirst()!!
//            notes = Notes(position,edt_title.text.toString(),"handsome")
            val newItem = Notes()
            newItem.id = item.id
            newItem.title = edt_title.text.toString()
            newItem.description = edt_des.text.toString()
            manager.editNote(realm, newItem)
            finish()
        }
    }
}