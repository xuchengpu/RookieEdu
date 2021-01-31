package com.cainiao.home.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cainiao.home.databinding.ItemHomeCourseBinding
import com.cainiao.home.databinding.ItemJobClassBinding
import com.cainiao.home.net.HomeCourseItem
import com.cainiao.home.net.JobClassList
import com.cainiao.home.net.NewClassList

/**
 * Created by 许成谱 on 2021/1/31 0031 18:59.
 * qq:1550540124
 * 热爱生活每一天！
 */
class HomeCourseAdapter(private val mList: List<HomeCourseItem>) :
    RecyclerView.Adapter<HomeCourseAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH.create(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size

    class VH(val binding: ItemHomeCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): VH {
                val itemBinding =
                    ItemHomeCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return VH(itemBinding)
            }
        }

        fun bind(info: HomeCourseItem) {
            binding.info = info
            binding.tvOldPriceItemCourse.paintFlags += Paint.STRIKE_THRU_TEXT_FLAG
            itemView.setOnClickListener {
//                WebActivity.openUrl(it.context, info.course?.h5site ?: "https://m.cniao5.com")
            }
            binding.executePendingBindings()
        }

    }

}