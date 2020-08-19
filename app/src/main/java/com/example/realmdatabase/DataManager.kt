package com.example.realmdatabase

import io.realm.Realm
import io.realm.RealmResults

@Suppress("DEPRECATION")
class DataManager : NoteInterface {
    override fun addNote(realm: Realm, notes: Notes): Boolean {
        return try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            print(e)
            false
        }
    }

    override fun delNote(realm: Realm, id: Int?): Boolean {
        return try {
            realm.beginTransaction()
            realm.where(Notes :: class.java).equalTo("id", id).findFirst()?.deleteFromRealm()
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            print(e)
            false
        }
    }

    override fun editNote(realm: Realm, notes: Notes): Boolean {
        return try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()
            true
        }catch (e:Exception){
            print(e)
            false
        }
    }

    override fun getNote(realm: Realm, noteId: Int): Notes {
        return realm.where(Notes::class.java).equalTo("id",noteId).findFirst()!!
    }
    fun getLastNote(realm: Realm): Notes {
        return realm.where(Notes::class.java).findAll().last()!!
    }

    fun getNotes(realm: Realm): RealmResults<Notes> {
        return realm.where(Notes::class.java).findAll()
    }

    override fun removeLastNote(realm: Realm) {
        realm.beginTransaction()
        getLastNote(realm).deleteFromRealm()
        realm.commitTransaction()
    }
}