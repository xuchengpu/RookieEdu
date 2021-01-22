package com.xcp.service.assistant

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.blankj.utilcode.util.ToastUtils
import com.cniao5.common.utils.Config.Companion.BASE_URL
import com.cniao5.common.utils.Config.Companion.TEST_BASE_URL
import com.cniao5.common.utils.getBaseHost
import com.cniao5.common.utils.setBaseHost
import com.didichuxing.doraemonkit.kit.AbstractKit
import com.xcp.service.R

/**
 * Created by 许成谱 on 2021/1/14 15:00.
 * qq:1550540124
 * 热爱生活每一天！
 * 自定义调试工具类，用于添加到dokit里切换host
 */
class ServiceHostKit : AbstractKit() {
    private val hostMap = mapOf<String, String>(
        "正式环境Host" to BASE_URL,
        "测试环境Host" to TEST_BASE_URL
    )
    private val hosts = hostMap.values.toTypedArray()
    private val names = hostMap.keys.toTypedArray()
    override val icon: Int
        get() = R.drawable.icon_server_host
    override val name: Int
        get() = R.string.str_server_host_dokit

    override fun onAppInit(context: Context?) {

    }

    override fun onClick(context: Context?) {
        val pos = hostMap.values.indexOf(getBaseHost()) % hosts.size
        context ?: return ToastUtils.showShort("context is null")
        AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.str_server_host_dokit))
            .setSingleChoiceItems(names, pos) { dialog, which ->
                setBaseHost(hosts[which])
                dialog.dismiss()
            }
            .show()
    }

}