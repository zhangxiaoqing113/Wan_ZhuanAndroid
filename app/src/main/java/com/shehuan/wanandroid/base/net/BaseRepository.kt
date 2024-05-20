package com.shehuan.wanandroid.base.net

import com.shehuan.wanandroid.base.net.exception.ApiException
import com.shehuan.wanandroid.base.net.exception.ExceptionHandler
import java.lang.Exception

open class BaseRepository {
//    suspend fun <T> Call<BaseResponse<T>>.await(): T {
//        return suspendCoroutine { continuation ->
//            enqueue(object : Callback<BaseResponse<T>> {
//                override fun onFailure(call: Call<BaseResponse<T>>, t: Throwable) {
//                    continuation.resumeWithException(t)
//                }
//
//                @Suppress("UNCHECKED_CAST")
//                override fun onResponse(
//                    call: Call<BaseResponse<T>>,
//                    response: Response<BaseResponse<T>>
//                ) {
//                    val body: BaseResponse<T> = response.body() as BaseResponse<T>
//                    if (0 != body.errorCode) {
//                        continuation.resumeWithException(
//                            ApiException(
//                                body.errorCode,
//                                body.errorMsg
//                            )
//                        )
//                    } else {
//                        if (body.data == null) {
//                            body.data = "" as T
//                        }
//                        continuation.resume(body.data)
//                    }
//                }
//            })
//        }
//    }

    suspend fun <T> executeRequest(request: suspend () -> BaseResponse<T>): T {
        val response: BaseResponse<T>
        try {
            response = request()
            if (response.errorCode != 0) {
                throw ApiException(response.errorCode, response.errorMsg)
            }
        } catch (e: Exception) {
            throw ExceptionHandler.handle(e)
        }
        return response.data
    }

   /* //switchs: (Int, String) -> Unit
    suspend fun testhaha(ha: Int, haha: Int, switchs: (Int, Int) -> Int) {
        switchs(ha, haha)
    }*/
}