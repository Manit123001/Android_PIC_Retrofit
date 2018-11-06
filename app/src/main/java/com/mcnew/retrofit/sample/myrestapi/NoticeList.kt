package com.mcnew.retrofit.sample.myrestapi

import com.google.gson.annotations.SerializedName

data class NoticeList(
        @SerializedName("notice_list")
        val noticeList: ArrayList<Notice>)
