package com.mcnew.retrofit.sample.myrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class NoticeAdapter() : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {
    private var dataList: ArrayList<Notice>? = null

    constructor(dataList: ArrayList<Notice>) : this() {
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_single_row, parent, false)
        return NoticeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.currentView = position
        dataList.let {
            if (it != null && it.size != 0) {
                holder.txtNoticeBrief.text = it[position].brief
                holder.txtNoticeTitle.text = it[position].title
                holder.txtNoticedPath.text = it[position].fileSource
            }
        }
    }

    class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentView: Int = 0
        val txtNoticeTitle = itemView.findViewById<TextView>(R.id.txt_notice_title)
        val txtNoticeBrief = itemView.findViewById<TextView>(R.id.txt_notice_brief)
        val txtNoticedPath = itemView.findViewById<TextView>(R.id.txt_notice_file_path)

        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Hello position: $currentView", Toast.LENGTH_SHORT).show()
            }
        }
    }
}