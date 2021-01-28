package com.cainiao.course.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseFragment
import com.cainiao.course.R
import com.cainiao.course.databinding.FragmentCourseBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by 许成谱 on 2021/1/13 18:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
class CourseFragment : BaseFragment() {
    private val viewModel: CourseViewModel by viewModel()
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentCourseBinding.bind(view).apply {
            val adapter=viewModel.courseAdapter
            rvCourse.adapter = adapter.withLoadStateFooter(CourseLoadAdapter(adapter))

            viewModel.apply {
                liveCourseType.observeKt { types ->
                    tlCategoryCourse.removeAllTabs()
                    val tab = tlCategoryCourse.newTab().also { tab ->
                        tab.text = "全部"
                    }
                    tlCategoryCourse.addTab(tab)

                    types?.forEach { item ->
                        tlCategoryCourse.addTab(
                            tlCategoryCourse.newTab().also { tab ->
                                tab.text = item.title
                            }
                        )

                    }
                    tlCategoryCourse.selectTab(tab)

                }
                tlCategoryCourse.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        val courseTypes = liveCourseType.value
                        val count = tlCategoryCourse.tabCount

                        val index = tab?.position ?: 0
                        val code = if (index > 0) {
                            courseTypes?.get(index)?.code ?: "all"
                        } else "all"

                        lifecycleScope.launchWhenCreated {
                            viewModel.apply {
                                getCourseList(code = code).collect {
                                    adapter.submitData(it)
                                    rvCourse.scrollToPosition(0)
                                }
                            }
                        }

                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {

                    }

                })

            }
            adapter.addLoadStateListener { loadState->
                if(loadState.refresh is LoadState.Loading){
                    pbFragmentCourse.visibility=View.VISIBLE
                }else{
                    pbFragmentCourse.visibility=View.GONE
                }
                // getting the error
                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                error?.let {
                    ToastUtils.showShort(it.error.message)
                }

            }
        }
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_course
    }

    override fun initConfig() {
        super.initConfig()
        viewModel.getCourseCategory()


    }
}