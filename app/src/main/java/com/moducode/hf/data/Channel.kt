package com.moducode.hf.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Channel(@field:SerializedName("name")
                   @field:Expose
                   val name: String,
                   @field:SerializedName("id")
                   @field:Expose
                   val id: Int): Parcelable
