package com.shehuan.wanandroid.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    private lateinit var fragments: List<Fragment>
    private lateinit var titles: List<String>

    fun setFragments(fragments: List<Fragment>) {
        this.fragments = fragments
    }

    fun setFragmentsAndTitles(fragments: List<Fragment>, titles: List<String>) {
        this.fragments = fragments
        this.titles = titles
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }


}