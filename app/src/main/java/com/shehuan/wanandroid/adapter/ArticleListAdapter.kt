package com.shehuan.wanandroid.adapter

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter
import com.shehuan.wanandroid.R
import com.shehuan.wanandroid.bean.article.DatasItem
import com.shehuan.wanandroid.databinding.RvItemArticleLayoutBinding
import com.shehuan.wanandroid.base.initDataBinding

class ArticleListAdapter(context: Context?, data: List<DatasItem>?, isOpenLoadMore: Boolean) :
    CommonBaseAdapter<DatasItem>(context, data, isOpenLoadMore) {
    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_article_layout
    }

    override fun convert(viewHolder: ViewHolder, data: DatasItem, position: Int) {
    /*    val binding =
            initDataBinding<RvItemArticleLayoutBinding>(
                viewHolder.convertView
            )*/

        val binding = DataBindingUtil.bind<RvItemArticleLayoutBinding>(viewHolder.convertView)!!

        binding.data = data
    }

    /*val listItemBinding = ListItemBinding.inflate(layoutInflater, viewGroup, false)
    // or
    val listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false)*/


}