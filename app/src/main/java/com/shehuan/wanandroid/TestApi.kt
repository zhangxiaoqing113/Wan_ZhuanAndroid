package com.shehuan.wanandroid

import com.shehuan.wanandroid.base.net.BaseResponse
import com.shehuan.wanandroid.bean.article.ArticleBean
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

public interface TestApi {
    //定义登录的方法，并通过@Filed注解配置请求体参数

    @FormUrlEncoded//会对请求体的数据进行url编码
    //请求登录所需要的两个参数，用户名和密码
    @POST("user/login")
    fun login(
        @Field("username") param1: String,
        @Field("password") params2: String,
    ): Call<ResponseBody>


    @GET("article/list/{pageNum}/json")
   suspend fun articleList(@Path("pageNum") pageNum:Int): BaseResponse<ArticleBean>

}
