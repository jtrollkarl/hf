package com.moducode.hf.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Socialmediaplatform(
        @field:SerializedName("platform")
        @field:Expose
        val platform: String,
        @field:SerializedName("platformurl")
        @field:Expose
        val platformurl: String)