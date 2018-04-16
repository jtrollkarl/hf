package com.moducode.hf.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Station(
        @field:SerializedName("copyright")
        @field:Expose
		val copyright: String,
        @field:SerializedName("programs")
        @field:Expose
		val programs: List<Program>,
        @field:SerializedName("pagination")
        @field:Expose
		val pagination: Pagination)








