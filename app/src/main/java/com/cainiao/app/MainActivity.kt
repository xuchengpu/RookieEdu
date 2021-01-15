package com.cainiao.app

import androidx.core.view.forEachIndexed
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cainiao.app.databinding.ActivityMainBinding
import com.cainiao.common.base.BaseActivity
import com.cainiao.common.widget.BnvMediator
import com.cainiao.course.CourseFragment
import com.cainiao.home.HomeFragment
import com.cainiao.mine.MineFragment
import com.cainiao.study.StudyFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    companion object {
        private const val INDEX_HOME = 0//对应bottomNavigationView的tab的index
        private const val INDEX_COURSE = 1//课程
        private const val INDEX_STUDY = 2//学习中心
        private const val INDEX_MINE = 3//我的
    }

    private val fragments = mapOf<Int, Fragment>(
        INDEX_HOME to HomeFragment(),
        INDEX_COURSE to CourseFragment(),
        INDEX_STUDY to StudyFragment(),
        INDEX_MINE to MineFragment()
    )

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()

    }

    override fun initConfig() {
        super.initConfig()
        mBinding.apply {
            vp2.adapter = MainViewPagerAdapter(this@MainActivity, fragments)

            BnvMediator(bnvMain,vp2){bnv, vp2 ->
//                vp2.isUserInputEnabled=false
            }.attach()
        }
    }

    override fun initData() {
        super.initData()
    }

}

/**
 * 首页的viewPager2的适配器
 */
class MainViewPagerAdapter(fragmentActivity: FragmentActivity, val fragments: Map<Int, Fragment>) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments.get(position) ?: error("请确保fragments数据源和viewPager2的index匹配设置")
    }

}
