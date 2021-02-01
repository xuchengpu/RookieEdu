package com.cainiao.course.ui

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.cainiao.common.webview.WebViewActivity
import com.cainiao.course.databinding.ItemCourseBinding
import com.cainiao.course.net.CourseList

/**
 * Created by 许成谱 on 2021/1/27 11:02.
 * qq:1550540124
 * 热爱生活每一天！
 */
class CoursePageAdapter :
    PagingDataAdapter<CourseList.Data, CourseViewHolder>(differCallback) {

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder.create(parent)
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<CourseList.Data>() {
            override fun areItemsTheSame(
                oldItem: CourseList.Data,
                newItem: CourseList.Data
            ) = oldItem.id == newItem.id
//            ) = false

            override fun areContentsTheSame(
                oldItem: CourseList.Data,
                newItem: CourseList.Data
            ) = oldItem == newItem
        }

    }
}

class CourseViewHolder(private val binding: ItemCourseBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): CourseViewHolder {
            return CourseViewHolder(
                ItemCourseBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(data: CourseList.Data?) {
        binding.info = data
        binding.tvOldPriceItemCourse.paint.flags += Paint.STRIKE_THRU_TEXT_FLAG
        itemView.setOnClickListener { v ->
            WebViewActivity.openUrl(v.context, "https://m.cniao5.com/course/${data?.id}")
        }
        binding.executePendingBindings()
    }
}