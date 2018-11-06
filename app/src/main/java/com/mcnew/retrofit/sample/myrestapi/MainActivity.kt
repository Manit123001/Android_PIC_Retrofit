package com.mcnew.retrofit.sample.myrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = RetrofitInstance().getRetrofitInstance()!!.create(GetNoticeDataService::class.java)
        val call = service.getNoticeData()
        call.enqueue(object : Callback<NoticeList> {
            override fun onFailure(call: Call<NoticeList>?, t: Throwable?) {
                // Handle
                Log.i("Retrofit API", "onFailure: Successful ${t.toString()}")
            }

            override fun onResponse(call: Call<NoticeList>?, response: Response<NoticeList>?) {
                if (response != null && response.isSuccessful) {
                    val noticeDao = response.body()!!.noticeList
                    Log.i("Retrofit API", "onResponse: Successful ${noticeDao.size}")
                    generateNoticeList(noticeDao)
                } else {
                    Log.i("Retrofit API", "onResponse: False")
                    try {
                        val responseError = response?.errorBody()?.string()
                        Log.i("Retrofit API", "$responseError")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }

    /** Method to generate List of notice using RecyclerView with custom adapter */
    private fun generateNoticeList(noticeArrayList: ArrayList<Notice>) {
        val layoutManager = GridLayoutManager(this, 2)
        val noticeAdapter = NoticeAdapter(noticeArrayList)

        recycler_view_notice_list.apply {
            adapter = noticeAdapter
            setLayoutManager(layoutManager)
        }
    }

}
