package com.example.realmdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlin.math.floor

class AddNoteAct : AppCompatActivity() {
    lateinit var realm: Realm
    var manager = DataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        realm = Realm.getDefaultInstance()
        btn_add.setOnClickListener {
//            generateRandomPassword()
//            Log.d("randomId",generateRandomPassword())
//            val currentIdNumber: Number? = realm.where(Notes::class.java).max("id")
//            val nextId: Int
//            nextId = if (currentIdNumber == null) {
//                1
//            } else {
//                currentIdNumber.toInt() + 1
//            }
            val notes = Notes()
            notes.title = edt_title.text.toString()
            notes.description = edt_des.text.toString()
            notes.id = generateRandomPassword()
            Log.d("notesId",notes.id)
            manager.addNote(realm, notes)
            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    fun generateRandomPassword(): String {
        val chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var id = ""
        var idSize = 0
        for (i in 0..31) {
            id += chars[floor(Math.random() * chars.length).toInt()]
            idSize += 1
            if(idSize >= 7 ){
                return id
            }
        }
        return id
    }

//    private fun addToRealm() {
//        try {
//            realm.beginTransaction()
//            val currentIdNumber: Number? = realm.where(Notes::class.java).max("id")
//            val nextId: Int
//            nextId = if (currentIdNumber == null) {
//                1
//            } else {
//                currentIdNumber.toInt() + 1
//            }
//            val notes = Notes()
//            notes.title = edt_title.text.toString()
//            notes.description = edt_des.text.toString()
//            notes.id = nextId
//
//            //copy this transaction
//            realm.copyToRealmOrUpdate(notes)
//            realm.commitTransaction()
//            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        } catch (e: Exception) {
//            Toast.makeText(this, "failed $e", Toast.LENGTH_SHORT).show()
//        }
//    }
}