package com.moducode.hf.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Socialmediaplatform(
        @field:SerializedName("platform")
        @field:Expose
        val platform: String,
        @field:SerializedName("platformurl")
        @field:Expose
        val platformurl: String) : Parcelable