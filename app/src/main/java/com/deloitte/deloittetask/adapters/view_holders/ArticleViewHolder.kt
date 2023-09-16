package com.deloitte.deloittetask.adapters.view_holders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.deloitte.deloittetask.BR
import com.deloitte.deloittetask.base.BaseAdapter
import com.deloitte.deloittetask.databinding.LayoutArticleItemBinding
import com.deloitte.deloittetask.repository.local_data_source.models.Article

class ArticleViewHolder constructor(private val binding: LayoutArticleItemBinding) :
    ViewHolder(binding.root),
    BaseAdapter.Binder<Article> {

    override fun bind(item: Article) {
        binding.setVariable(BR.article, item)
        binding.setVariable(BR.imageUrl, item.imageUrl)
    }


}