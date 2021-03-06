package com.namget.myarchitecture.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.namget.myarchitecture.R
import com.namget.myarchitecture.data.response.RepoListResponse
import com.namget.myarchitecture.databinding.ItemSearchBinding

/**
 * Created by Namget on 2019.10.22.
 */
class SearchAdapter(
    diffCallback: DiffUtil.ItemCallback<RepoListResponse.RepoItem>,
    private val selectedCallback: (Int) -> Unit
) :
    ListAdapter<RepoListResponse.RepoItem, SearchViewHolder>(diffCallback) {

    fun getAdapterItem(position: Int): RepoListResponse.RepoItem {
        return getItem(position)
    }

    override fun submitList(submitList: List<RepoListResponse.RepoItem>?) {
        val list: MutableList<RepoListResponse.RepoItem> = arrayListOf()
        submitList?.let { list.addAll(submitList) }
        super.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = DataBindingUtil.inflate<ItemSearchBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_search,
            parent,
            false
        )
        return SearchViewHolder(binding, selectedCallback)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}