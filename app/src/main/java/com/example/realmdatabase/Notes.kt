package com.example.realmdatabase
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Notes(
    @PrimaryKey() var id: String? = null,
    var title: String? = null,
    var description: String? = null
) : RealmObject(), Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readValue(Int::class.java.classLoader) as? Int,
//        parcel.readString(),
//        parcel.readString()
//    ) {
//    }
//
//    override fun describeContents(): Int = 0
//
//    override fun writeToParcel(dest: Parcel?, flags: Int) {
//        dest?.writeInt(id!!)
//        dest?.writeString(title)
//        dest?.writeString(description)
//    }
//

}