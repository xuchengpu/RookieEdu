package com.cainiao.mine.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.Keep
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.ObservableField
import com.cainiao.mine.R
import com.cainiao.mine.databinding.VItemSettingsBinding

/**
 * Created by 许成谱 on 2021/1/18 0018 22:02.
 * qq:1550540124
 * 热爱生活每一天！
 */
class ItemSettingsView @JvmOverloads constructor(//JvmOverloads会重载每个参数
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var itemBean = ItemSettingsBean()
    var info = ObservableField(itemBean)

    init {
        //1、绑定view
        VItemSettingsBinding.inflate(LayoutInflater.from(context), this, true).apply {
            info=this@ItemSettingsView.info
        }
        setBackgroundColor(Color.WHITE)

    }

    //2、定义绑定的实体类
    @Keep
    data class ItemSettingsBean(
        var iconRes: Any = R.drawable.ic_gift_card,
        var title: String = "",
        var desc: String = "",
        var titleColor: Int = R.color.colorPrimaryText,
        var descColor: Int = R.color.colorSecondaryText,
        var iconColor: Int = 0,
        var arrowColor: Int = 0,
        var arrowRes: Any = R.drawable.ic_right
    )

}