package com.example.realmdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_edit.*

class EditAct : AppCompatActivity() {
    var main = MainActivity()
    lateinit var realm: Realm
    lateinit var notes: Notes
    var manager = DataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        realm = Realm.getDefaultInstance()
        var getIntent = intent
        var position = getIntent.getIntExtra("obPosition", 0)

        btn_edit.setOnClickListener {
            notes = realm.where(Notes::class.java)
                .equalTo("id", position)
                .findFirst()!!
            notes = Notes(position,edt_title.text.toString(),"handsome")
            manager.editNote(realm, notes)
            finish()
        }
    }
}