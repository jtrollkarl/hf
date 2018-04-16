package com.moducode.hf.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Channel(@field:SerializedName("name")
                   @field:Expose
                   val name: String,
                   @field:SerializedName("id")
                   @field:Expose
                   val id: Int)
