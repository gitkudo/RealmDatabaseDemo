package com.example.realmdatabase

import io.realm.Realm

interface NoteInterface {
    fun addNote(realm: Realm,notes: Notes):Boolean
    fun delNote(realm: Realm,id:Int?):Boolean
    fun editNote(realm: Realm ,notes: Notes):Boolean
    fun getNote(realm: Realm,noteId:Int):Notes
    fun removeLastNote(realm: Realm)
}