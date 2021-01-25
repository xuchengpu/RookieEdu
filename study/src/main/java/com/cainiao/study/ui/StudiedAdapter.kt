package com.cainiao.study.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cainiao.study.databinding.ItemCourseStudyBinding
import com.cainiao.study.net.StudiedRsp

/**
 * Created by 许成谱 on 2021/1/25 10:50.
 * qq:1550540124
 * 热爱生活每一天！
 */
class StudiedAdapter : RecyclerView.Adapter<StudiedVH>() {

    private val mList = mutableListOf<StudiedRsp.Data>()

    fun submit(list: List<StudiedRsp.Data>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StudiedVH.createVH(parent)

    override fun onBindViewHolder(holder: StudiedVH, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size


}

class StudiedVH(private val binding: ItemCourseStudyBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun createVH(parent: ViewGroup): StudiedVH {
            return StudiedVH(
                ItemCourseStudyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(info: StudiedRsp.Data) {
        binding.info = info
        binding.npbProgressItemStudy.progress = info.progress.toInt()
        binding.executePendingBindings()
    }
}
