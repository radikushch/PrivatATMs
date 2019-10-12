package com.test.privatatms.model.atm

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class WorkSchedule(
    @SerializedName("mon")
    val mon: String,
    @SerializedName("tue")
    val tue: String,
    @SerializedName("wed")
    val wed: String,
    @SerializedName("thu")
    val thu: String,
    @SerializedName("fri")
    val fri: String,
    @SerializedName("sat")
    val sat: String,
    @SerializedName("sun")
    val sun: String,
    @SerializedName("hol")
    val hol: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(mon)
        parcel.writeString(tue)
        parcel.writeString(wed)
        parcel.writeString(thu)
        parcel.writeString(fri)
        parcel.writeString(sat)
        parcel.writeString(sun)
        parcel.writeString(hol)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkSchedule> {
        override fun createFromParcel(parcel: Parcel): WorkSchedule {
            return WorkSchedule(parcel)
        }

        override fun newArray(size: Int): Array<WorkSchedule?> {
            return arrayOfNulls(size)
        }
    }
}
