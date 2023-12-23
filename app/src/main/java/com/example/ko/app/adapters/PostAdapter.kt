package com.example.ko.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ListAdapter
import com.example.ko.data.model.PostsItem
import com.example.ko.databinding.PostsRowBinding

class PostAdapter(var context: Context?): ListAdapter<PostsItem,PostViewHolder>(PostDiffutil()) {

    lateinit var binding: PostsRowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding= PostsRowBinding.inflate(inflater,parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem=getItem(position)
        holder.binding.textView.text = currentItem.body

    }
}