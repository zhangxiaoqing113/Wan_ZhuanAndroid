package com.shehuan.wanandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.shehuan.wanandroid.base.net.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ApiException
import com.shehuan.wanandroid.bean.article.ArticleBean
import com.shehuan.wanandroid.utils.ToastUtil
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_rxjava.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Properties
import kotlin.coroutines.*


class RxJavaActivity : AppCompatActivity() {

    companion object {
        var retrofit = Retrofit.Builder()
            //我们使用鸿洋大神的wanAndroid的开放api进行网络请求测试
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        var testApi = retrofit.create(TestApi::class.java)
    }

    private val TAG = "RxJavaActivity"
    var button: Button? = null
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
        button = findViewById(R.id.btn)
        textView = findViewById(R.id.tv)
        btn.setOnClickListener() {
            //funCoroutine01()
            funCoroutine02()
          //  Observer01()
            //Observer02()
        }

    }

    private fun funCoroutine02() {
        suspend {
            var response: BaseResponse<ArticleBean> = testApi.articleList(0)
            response
        }.createCoroutine(object :Continuation<BaseResponse<ArticleBean>>{
            override val context: CoroutineContext
                get()=EmptyCoroutineContext

            override fun resumeWith(result: Result<BaseResponse<ArticleBean>>) {
                Log.d(TAG, "resumeWith: "+result.getOrNull()?.data)
            }

        }).resume(Unit)

    }

    fun funCoroutine01() {
        try {
            Log.d(TAG, "000000000000")
            GlobalScope.launch {
                Log.d(TAG, "thread1 " + Thread.currentThread())
                var response: BaseResponse<ArticleBean> = testApi.articleList(0)
                Log.d(TAG, "onCreate response: " + response.data)
                Log.d(TAG, "thread2 " + Thread.currentThread())
            }.start()
            Log.d(TAG, "333333333333")
        } catch (e: Exception) {
            Log.d(TAG, "onCreate: " + e.message)
        }
        Log.d(TAG, "44444444444444")
    }

    fun Observer02() {
       // var  properties=Properties()

        var login: Call<ResponseBody> = testApi.login("qfh", "qfhqfh1741")
        btn.setOnClickListener {
            Observable.create(object : ObservableOnSubscribe<ResponseBody> {
                override fun subscribe(emitter: ObservableEmitter<ResponseBody>) {
                    var execute: Response<ResponseBody>? = null
                    try {
                        execute = login.execute()
                    } catch (e: Exception) {
                        throw  RuntimeException(e);
                    }

                    emitter.onNext(execute.body());
                    emitter.onComplete();
                }

            }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ResponseBody> {
                    override fun onSubscribe(d: Disposable) {
                        Log.d(TAG, "onSubscribe: {${d.isDisposed}}")
                    }

                    override fun onNext(t: ResponseBody) {
                        var responseData: String? = null  // 使用保存的结果
                        try {
                            responseData = t.string();
                        } catch (e: Exception) {
                            throw  RuntimeException(e);
                        }
                        Log.e(TAG, "onNextqqfh: " + responseData);
                        textView?.setText(responseData);

                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "An error occurred: " + e.message);
                    }

                    override fun onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }

                })
        }
    }


    fun Observer01() {
        var observable = Observable.create<String>(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                emitter.onNext("hello")
                emitter.onNext("world")
                emitter.onComplete()
            }

        })
        var observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.e(TAG, "onSubscribe: " + d.isDisposed());
            }

            override fun onNext(t: String) {
                Log.e(TAG, "onNext: " + t);
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: " + e.getLocalizedMessage())
            }

            override fun onComplete() {
                Log.e(TAG, "onComplete: ")
            }

        }
        //订阅
        observable.subscribe(observer)


    }
}
