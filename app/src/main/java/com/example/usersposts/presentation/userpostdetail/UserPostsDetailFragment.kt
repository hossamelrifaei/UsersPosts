package com.example.usersposts.presentation.userpostdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.usersposts.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_users_posts_detail.img_prof_pic
import kotlinx.android.synthetic.main.fragment_users_posts_detail.posts_list


@AndroidEntryPoint
class UserPostsDetailFragment() : Fragment() {
    private val viewModel by viewModels<UserPostsDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users_posts_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { user ->
            posts_list.adapter = PostListAdapter(user.posts)
            Glide.with(this)
                .load(user.url)
                .fitCenter()
                .into(img_prof_pic)
        }
    }
}