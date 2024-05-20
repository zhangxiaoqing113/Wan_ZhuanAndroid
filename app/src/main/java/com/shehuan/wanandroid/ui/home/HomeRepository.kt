package com.shehuan.wanandroid.ui.home

import com.shehuan.wanandroid.RxJavaActivity
import com.shehuan.wanandroid.base.net.BaseRepository
import com.shehuan.wanandroid.base.net.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import java.lang.reflect.Type

class HomeRepository : BaseRepository() {
    suspend fun collectArticle(id: Int) =
        executeRequest { RetrofitManager.getApis().collectArticle(id) }

    suspend fun uncollectArticle(id: Int) =
        executeRequest { RetrofitManager.getApis().uncollectArticle(id) }

    suspend fun getBannerList() =
        executeRequest { RetrofitManager.getApis().banner() }


    suspend fun getArticleList(pageNum: Int) =
        executeRequest { RetrofitManager.getApis().articleList(pageNum) }


    //----------------------start----------------
/*    var ha = fun(he: Int, hehe: Int): Int {
        return he + hehe
    }

    suspend fun haha() = testhaha(2, 3, ha)
    suspend fun ha() = testhaha(2, 3) { x, y ->
        x + y
    }

    var tete = { he: Int, hehe: Int -> he + hehe }
    suspend fun ha1() = testhaha(2, 3, tete)
    suspend fun ha2() = testhaha(2, 3, { he: Int, hehe: Int -> he + hehe })
    suspend fun ha3() = testhaha(2, 3) { he: Int, hehe: Int -> he + hehe }
    suspend fun ha4() = testhaha(2, 3) { he, hehe -> he + hehe }


    //request: suspend () -> BaseResponse<T>
    //() -> BaseResponse<T> 对应的匿名方法对象是
    var xiha = fun(): BaseResponse<Int> {
        return BaseResponse<Int>("das", 9, 3)
    }

    //executeRequest的形参是 () -> BaseResponse<T>.那么对应的lamda表达式就是 { -> BaseResponse<Int>(...) }
    var xixi = { -> BaseResponse<Int>("das", 9, 3) }
    var xihaha = { BaseResponse<Int>("das", 9, 3) }
    suspend fun getTest() = executeRequest(xixi)
    suspend fun getTest1() = executeRequest(xiha)
    suspend fun getTest2() = executeRequest(xihaha)
    suspend fun getTest3() = executeRequest {
        BaseResponse<Int>("das", 9, 3)
    }*/
//----------------------end----------------

}