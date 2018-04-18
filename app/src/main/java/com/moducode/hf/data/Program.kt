package com.moducode.hf.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Program(
        @field:SerializedName("description")
        @field:Expose
        val description: String?,
        @field:SerializedName("programcategory")
        @field:Expose
        val programcategory: Programcategory?,
        @field:SerializedName("email")
        @field:Expose
        val email: String?,
        @field:SerializedName("phone")
        @field:Expose
        val phone: String?,
        @field:SerializedName("programurl")
        @field:Expose
        val programurl: String?,
        @field:SerializedName("programslug")
        @field:Expose
        val programslug: String?,
        @field:SerializedName("programimage")
        @field:Expose
        val programimage: String?,
        @field:SerializedName("programimagetemplate")
        @field:Expose
        val programimagetemplate: String?,
        @field:SerializedName("programimagewide")
        @field:Expose
        val programimagewide: String?,
        @field:SerializedName("programimagetemplatewide")
        @field:Expose
        val programimagetemplatewide: String?,
        @field:SerializedName("socialimage")
        @field:Expose
        val socialimage: String?,
        @field:SerializedName("socialimagetemplate")
        @field:Expose
        val socialimagetemplate: String?,
        @field:SerializedName("socialmediaplatforms")
        @field:Expose
        val socialmediaplatforms: List<Socialmediaplatform>?,
        @field:SerializedName("channel")
        @field:Expose
        val channel: Channel?,
        @field:SerializedName("archived")
        @field:Expose
        val archived: Boolean?,
        @field:SerializedName("hasondemand")
        @field:Expose
        val hasondemand: Boolean?,
        @field:SerializedName("haspod")
        @field:Expose
        val haspod: Boolean?,
        @field:SerializedName("responsibleeditor")
        @field:Expose
        val responsibleeditor: String?,
        @field:SerializedName("id")
        @field:Expose
        val id: Int?,
        @field:SerializedName("name")
        @field:Expose
        val name: String?) : Parcelable
