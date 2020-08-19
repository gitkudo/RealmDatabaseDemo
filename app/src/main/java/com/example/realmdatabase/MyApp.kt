package com.example.realmdatabase

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("DemoRealm.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .build()
        Realm.setDefaultConfiguration(config)
    }
}