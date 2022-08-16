package com.example.usersposts.presentation.userpostdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersposts.R
import com.example.usersposts.domain.model.UsersModel
import com.example.usersposts.presentation.userpostdetail.PostListAdapter.PostViewHolder
import kotlinx.android.synthetic.main.list_item_post.view.tv_body
import kotlinx.android.synthetic.main.list_item_post.view.tv_title

class PostListAdapter(private val posts: List<UsersModel.Post>) :
    RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: UsersModel.Post) {
            itemView.apply {
                tv_title.text = post.title
                tv_body.text = post.body
            }
        }
    }
}

