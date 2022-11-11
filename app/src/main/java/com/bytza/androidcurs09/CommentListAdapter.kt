package com.bytza.androidcurs09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bytza.androidcurs09.databinding.CommentListItemBinding
import com.bytza.androidcurs09.model.Comment

class CommentListAdapter(): RecyclerView.Adapter<CommentListAdapter.ViewHolder>() {
    private var comments: List<Comment> = mutableListOf()

    fun setComments(list: List<Comment>?) {
        if (list != null) {
            comments = list
            notifyDataSetChanged()
        }
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = CommentListItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.comment = comments[position]
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}