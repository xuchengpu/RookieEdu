package com.cainiao.study.net

import com.xcp.service.network.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by 许成谱 on 2021/1/24 0024 18:37.
 * qq:1550540124
 * 热爱生活每一天！
 */
interface StudyService {
    /**
     * 用户学习详情
     */
    @GET(value = "/member/study/info")
    fun getStudyInfo(): Call<BaseResponse>

    /**
     * 用户学习过的用户列表
     */
    @GET(value = "/member/courses/studied")
    fun getStudyList(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10
    ): Call<BaseResponse>

    /**
     * 用户购买的课程
     * 同样有page和size，默认 1，和 10
     */
    @GET("/member/courses/bought")
    fun getBoughtCourse(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10
    ): Call<BaseResponse>


    //region 页面配置，废弃api
    /**
     * 获取模块组件列表
     */
    @GET("/allocation/component/list")
    fun getModuleList(@Query("module_id") moduleId: Int): Call<BaseResponse>

    /**
     * 获取页面列表
     */
    @GET("/allocation/page/list")
    fun getPageList(): Call<BaseResponse>

    /**
     * 根据页面id 获取页面的模块列表
     */
    @GET("/allocation/module/list")
    fun getPageModuleList(@Query("page_id") pageId: Int): Call<BaseResponse>

    //endregion

    /**
     * 根据课程key，获取播放地址
     */
    @GET("/lesson/play/v2")
    fun getCoursePlayUrl(@Query("key") key: String): Call<BaseResponse>


    /**
     * banner列表
     * [type]类型 1:小程序 2:web 3:h5 4:ios 5:android 如: 2表示web 默认2
     * [show]页面显示 1 首页 2 课程 3 大数据学院 4 机器人学院 5 人工智能学院 6 推广员 默认1
     * @Query("type") type: Int=5, @Query("page_show") show: Int 不传参了，现在据首页有数据，且type = web
     */
    @GET("/ad/new/banner/list")
    fun getBannerList(): Call<BaseResponse>


    /**
     * 获取老师列表
     */
    @GET("/teacher/list")
    fun getTeacherList(): Call<BaseResponse>

    /**
     * 根据teacher的id 获取老师的课程
     */
    @GET("/teacher/courses")
    fun getTeacherCourseList(@Query("id") id: Int): Call<BaseResponse>

    /**
     * 根据teacher的id 获取老师的基本信息
     */
    @GET("/teacher/detail")
    fun getTeacherInfo(@Query("id") id: Int): Call<BaseResponse>


    /**
     * 根据course_id 查询当前学员是否有课程，班级的权限
     */
    @GET("/course/authority")
    fun getCoursePermission(@Query("course_id") courseId: Int): Call<BaseResponse>


    /**
     * 课程分类
     */
    @GET("/course/category")
    fun getCourseCategory(): Call<BaseResponse>

    /**
     * 课程列表v2,根据code入参，分类python，java，android等类别下的课程列表，，就是课程页面的所有，有入参
     */
    @GET("/course/v2/list")
    fun getCourseList(): Call<BaseResponse>


    /**
     * 收藏/取消收藏课程
     */
//    @POST("/course/favorites")
//    fun postFavorites(@Body body: FavoriteReq): Call<BaseResponse>


    /**
     * 根据course_id 查询相关推荐
     */
    @GET("/course/related/recommend")
    fun getRecommend(@Query("course_id") courseId: Int): Call<BaseResponse>


    /**
     * 根据course_id 查询课程章节
     */
    @GET("/course/chapter")
    fun getCourseChapter(@Query("course_id") courseId: Int): Call<BaseResponse>


    /**
     * 根据course_id 查询课程详情
     */
    @GET("/course/detail")
    fun getCourseInfo(@Query("course_id") courseId: Int): Call<BaseResponse>

}