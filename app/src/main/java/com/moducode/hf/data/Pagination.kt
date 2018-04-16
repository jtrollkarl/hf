package com.moducode.hf.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pagination (@field:SerializedName("page")
                  @field:Expose
                  val page: Int,
                  @field:SerializedName("size")
                  @field: Expose
                  val size: Int,
                  @field:SerializedName("totalhits")
                  @field:Expose
                  val totalHits: Int,
                  @field:SerializedName("totalpages")
                  @field:Expose
                  val totalPages: Int,
                  @field:SerializedName("nextpage")
                  @field:Expose
                  val nextPage: String)
