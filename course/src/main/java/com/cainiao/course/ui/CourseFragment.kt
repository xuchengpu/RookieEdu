package com.cainiao.course.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.cainiao.common.base.BaseFragment
import com.cainiao.course.R
import com.cainiao.course.databinding.FragmentCourseBinding
import com.cainiao.course.repo.CourseReposity
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
            rvCourse.adapter = viewModel.courseAdapter
        }
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_course
    }

    override fun initConfig() {
        super.initConfig()
        viewModel.getCourseCategory()
        lifecycleScope.launchWhenCreated {
            viewModel.apply {
                getCourseList().collect {
                    courseAdapter.submitData(it)
                }
            }
        }

    }
}