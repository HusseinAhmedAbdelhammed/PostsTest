package com.example.ko.app.ui

import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ko.R
import com.example.ko.app.adapters.PostAdapter
import com.example.ko.app.viewmodel.PostsViewModel
import com.example.ko.databinding.FragmentPostBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class PostFragment : Fragment() {

    lateinit var binding:FragmentPostBinding
    private val viewModel by viewModel<PostsViewModel>()
    lateinit var adapterPost: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPosts()
        lifecycleScope.launch {

            viewModel.postsResponse.collect{
                when(it){
                    is ResponseState.OnError -> {

                    }
                    is ResponseState.OnLoading -> {

                    }
                    is ResponseState.OnSuccess -> {
                        adapterPost = PostAdapter(requireContext())
                        adapterPost.submitList(it.response)
                        binding.reView.apply {
                            adapter = adapterPost
                            layoutManager= LinearLayoutManager(context).apply {
                                orientation= RecyclerView.VERTICAL
                            }
                        }
                    }
                }
            }
        }
    }

}