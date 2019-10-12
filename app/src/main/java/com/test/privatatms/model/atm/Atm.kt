package com.test.privatatms.model.atm

import android.os.Parcel
import android.os.Parcelable
import android.text.Spannable
import android.text.SpannableString
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.test.privatatms.consts.ViewTypeConsts
import com.test.privatatms.presentation.adapter.model.SearchItem

@Entity(tableName = "atms")
data class Atm(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "type")
    @SerializedName("type")
    val type: String,
    @ColumnInfo(name = "cityRU")
    @SerializedName("cityRU")
    val cityRU: String,
    @ColumnInfo(name = "fullAddressRu")
    @SerializedName("fullAddressRu")
    val fullAddressRu: String,
    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    val latitude: Double,
    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("tw")
    @Embedded
    val tw: WorkSchedule? = null,
    @ColumnInfo(name = "isFavourite")
    var isFavourite: Boolean = false
): SearchItem, Parcelable {

    @Ignore
    private val searchField: Spannable = SpannableString(fullAddressRu)

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readParcelable(WorkSchedule::class.java.classLoader),
        parcel.readByte() != 0.toByte()
    )


    override fun getSearchField(): Spannable = searchField

    override fun getViewType(): Int = ViewTypeConsts.ATM_VIEW_TYPE
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(type)
        parcel.writeString(cityRU)
        parcel.writeString(fullAddressRu)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeParcelable(tw, flags)
        parcel.writeByte(if (isFavourite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Atm> {
        override fun createFromParcel(parcel: Parcel): Atm {
            return Atm(parcel)
        }

        override fun newArray(size: Int): Array<Atm?> {
            return arrayOfNulls(size)
        }
    }
}

