package com.food.arch.model.response

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @SerializedName("emp_name") val name: String,
    @SerializedName("emp_pic_url") val imageUrl: String,
    @SerializedName("emp_phone") val phone: String,
    @SerializedName("city_name") val cityName: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.run {
            writeValue(id)
            writeString(name)
            writeString(imageUrl)
            writeString(phone)
            writeString(cityName)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }

        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}
