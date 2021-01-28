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
import com.cainiao.course.databinding.ItemCourseBinding
import com.cainiao.course.net.CourseList

/**
 * Created by 许成谱 on 2021/1/27 11:02.
 * qq:1550540124
 * 热爱生活每一天！
 */
class CoursePageAdapter :
    PagingDataAdapter<CourseList.Data, CourseViewHolder>(CourseItemCallBack()) {

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        getItem(position)?.apply {
            holder.bind(this)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder.create(parent)
    }


}

class CourseItemCallBack : DiffUtil.ItemCallback<CourseList.Data>() {
    override fun areItemsTheSame(oldItem: CourseList.Data, newItem: CourseList.Data): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: CourseList.Data, newItem: CourseList.Data): Boolean {
        return oldItem == newItem
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
        binding.executePendingBindings()
    }
}