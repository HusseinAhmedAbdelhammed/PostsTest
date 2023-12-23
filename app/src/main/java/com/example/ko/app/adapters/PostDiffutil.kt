package com.example.ko.app.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ko.data.model.PostsItem

class PostDiffutil: DiffUtil.ItemCallback<PostsItem>() {

    override fun areItemsTheSame(
        oldItem: PostsItem,
        newItem: PostsItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PostsItem,
        newItem: PostsItem
    ): Boolean {
        return oldItem == newItem
    }
}