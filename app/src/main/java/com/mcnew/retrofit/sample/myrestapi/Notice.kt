package com.mcnew.retrofit.sample.myrestapi

import com.google.gson.annotations.SerializedName

data class Notice(
        @SerializedName("id")
        val id: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("brief")
        val brief: String? = null,
        @SerializedName("filesource")
        val fileSource: String? = null)