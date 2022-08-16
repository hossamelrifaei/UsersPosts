package com.example.usersposts.presentation.userspostslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usersposts.R
import com.example.usersposts.domain.model.UsersModel
import com.example.usersposts.presentation.userspostslist.UsersListAdapter.UserViewHolder
import kotlinx.android.synthetic.main.list_item_user.view.img_prof_pic
import kotlinx.android.synthetic.main.list_item_user.view.tv_profile_name
import kotlinx.android.synthetic.main.list_item_user.view.tv_profile_posts_count

class UsersListAdapter(
    private val users: List<UsersModel>,
    private val listener: (user: UsersModel) -> Unit
) : RecyclerView.Adapter<UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }


    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(usersModel: UsersModel) {
            itemView.apply {
                tv_profile_name.text = usersModel.name
                tv_profile_posts_count.text = usersModel.posts.size.toString()
                Glide.with(this)
                    .load(usersModel.thumbnailUrl)
                    .fitCenter()
                    .into(img_prof_pic)
                setOnClickListener {
                    listener.invoke(usersModel)
                }
            }
        }

    }
}
