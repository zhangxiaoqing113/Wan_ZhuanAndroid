package com.shehuan.wanandroid.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.shehuan.wanandroid.R

class BottomTabLayout : LinearLayout {

    private var currentTabIndex = 0
    private lateinit var viewPager: ViewPager

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        orientation = HORIZONTAL
    }

    fun addTab(tabName: String, defaultIconId: Int, selectIconId: Int) {
        val tab = TabItem(context, tabName, defaultIconId, selectIconId)
        tab.tag = childCount
        tab.setOnClickListener {
            val tag: Int = it.tag as Int
            if (tag != currentTabIndex) {
                viewPager.setCurrentItem(tag, true)
            }
        }

        if (childCount == 0)
            tab.select()

        val params = LayoutParams(0, LayoutParams.MATCH_PARENT)
        params.weight = 1f

        addView(tab, params)
    }

    fun setupWithViewPager(viewPager: ViewPager) {
        this.viewPager = viewPager
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(i: Int) {

            }

            override fun onPageScrolled(i: Int, v: Float, i1: Int) {

            }

            override fun onPageSelected(i: Int) {
                if (i != currentTabIndex)
                    switchTab(i)
            }
        })
    }

    fun switchTab(destTabIndex: Int) {
        val destTab: TabItem = getChildAt(destTabIndex) as TabItem
        destTab.select()
        // listener.onTabSwitch(destTabIndex, destTab.tabName())
        tabSwitch(destTabIndex, destTab.tabName())
        val currentTab: TabItem = getChildAt(currentTabIndex) as TabItem
        currentTab.unSelect()
        currentTabIndex = destTabIndex
    }

    private lateinit var listener: OnTabSwitchListener

    fun setOnTabSwitchListener(listener: OnTabSwitchListener) {
        this.listener = listener
    }

    //------开始 自己写的
    //kotlin中 新增了函数对象的概念
    var test1 = ::setOnTabSwitchListener

    //匿名函数对象
    private var tabSwitch = fun(ha: Int, haha: String): Unit {

    }

    //参数为lamda表达式 其实质上还是函数对象
    fun setTabSwitch(switchs: (Int, String) -> Unit) {
        tabSwitch = switchs
    }
    //---------结束


    interface OnTabSwitchListener {
        fun onTabSwitch(tabIndex: Int, tabName: String)
    }

    @SuppressLint("ViewConstructor")
    private class TabItem(
        context: Context?,
        nameStr: String,
        private val defaultIconId: Int,
        private val selectIconId: Int
    ) : LinearLayout(context) {
        private val iconIv: ImageView
        private val nameTv: TextView
        private val TAG = "BottomTabLayout"

        init {

            orientation = VERTICAL
            val tab: LinearLayout = inflate(R.layout.tab_item_bottom_layout) as LinearLayout
            iconIv = tab.findViewById(R.id.tabIcon)
            iconIv.setImageResource(defaultIconId)
            nameTv = tab.findViewById(R.id.tabName)
            nameTv.text = nameStr
            Log.d(TAG, "nameStr= {$nameStr} ")
        }

        fun select() {
            iconIv.setImageResource(selectIconId)
            nameTv.setTextColor(resources.getColor(R.color.cFE6243))
        }

        fun unSelect() {
            iconIv.setImageResource(defaultIconId)
            nameTv.setTextColor(resources.getColor(R.color.c707070))
        }

        fun tabName() = nameTv.text.toString()

        private fun inflate(layoutId: Int): View =
            LayoutInflater.from(context).inflate(layoutId, this)

    }
}