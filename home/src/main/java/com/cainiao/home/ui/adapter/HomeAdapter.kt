package com.cainiao.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cainiao.home.databinding.ItemHomeBinding
import com.cainiao.home.net.HomeList

/**
 * Created by 许成谱 on 2021/1/31 0031 10:41.
 * qq:1550540124
 * 热爱生活每一天！
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeAdapterVH>() {
    private var datas: HomeList? = null

    class HomeAdapterVH(itemHomeBinding: ItemHomeBinding) :
        RecyclerView.ViewHolder(itemHomeBinding.root) {
        companion object {
            fun create(parent: ViewGroup): HomeAdapterVH {
                val mBinding =
                    ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return HomeAdapterVH(mBinding)
            }
        }

        fun bind() {

        }


    }

    fun updateList() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterVH {

        return HomeAdapterVH.create(parent)
    }

    override fun onBindViewHolder(holder: HomeAdapterVH, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }
}