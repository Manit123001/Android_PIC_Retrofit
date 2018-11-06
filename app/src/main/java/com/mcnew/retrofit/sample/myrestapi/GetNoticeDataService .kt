package com.mcnew.retrofit.sample.myrestapi

import retrofit2.Call
import retrofit2.http.GET

interface GetNoticeDataService {
    @GET("bins/1bsqcn/")
    fun getNoticeData(): Call<NoticeList>
}
