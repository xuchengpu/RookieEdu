package com.cainiao.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cainiao.home.databinding.ItemJobClassBinding
import com.cainiao.home.databinding.ItemTeacherBinding
import com.cainiao.home.net.JobClassList
import com.cainiao.home.net.PopTeacherList

/**
 * Created by 许成谱 on 2021/1/31 0031 19:04.
 * qq:1550540124
 * 热爱生活每一天！
 */
class TeacherAdapter (val popTeacherList: PopTeacherList) : RecyclerView.Adapter<TeacherAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH.create(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(popTeacherList[position])
    }

    override fun getItemCount(): Int {
        return popTeacherList.size
    }

    class VH(val binding: ItemTeacherBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): VH {
                val itemBinding =
                    ItemTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return VH(itemBinding)
            }
        }
        fun bind(info: PopTeacherList.PopTeacherListItem) {
            binding.info = info
            itemView.setOnClickListener {
//                WebActivity.openUrl(it.context, info.course?.h5site ?: "https://m.cniao5.com")
            }
            binding.executePendingBindings()
        }

    }

}