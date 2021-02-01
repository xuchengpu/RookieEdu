package com.cainiao.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cainiao.common.webview.WebViewActivity
import com.cainiao.home.databinding.ItemJobClassBinding
import com.cainiao.home.net.JobClassList

/**
 * Created by 许成谱 on 2021/1/31 0031 18:44.
 * qq:1550540124
 * 热爱生活每一天！
 */
class JobClassAdapter(val jobClassList: JobClassList) : RecyclerView.Adapter<JobClassAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH.create(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(jobClassList[position])
    }

    override fun getItemCount(): Int {
        return jobClassList.size
    }

    class VH(val binding: ItemJobClassBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): VH {
                val itemBinding =
                    ItemJobClassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return VH(itemBinding)
            }
        }

        fun bind(info: JobClassList.JobClassListItem) {
            binding.url = info.course?.img_url
            itemView.setOnClickListener {
                WebViewActivity.openUrl(it.context, info.course?.h5site ?: "https://m.cniao5.com")
            }
            binding.executePendingBindings()
        }

    }

}