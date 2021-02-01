package com.example.instagroy.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagroy.core.ViewHolderBase
import com.example.instagroy.data.model.User
import com.example.instagroy.databinding.HistoryMainItemBinding
import com.example.instagroy.presentation.InicioViewModel

class ViewHistory(
    private val userList: List<User>,
    private val itemClickListener: OnHistoryClickListener
) : RecyclerView.Adapter<ViewHolderBase<*>>() {

    interface OnHistoryClickListener {
        fun onHistoryClick(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBase<*> {
        val itemBinding =
            HistoryMainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = InicioViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onHistoryClick(userList[position])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolderBase<*>, position: Int) {
        when(holder) {
            is InicioViewHolder -> holder.bind(userList[position])
        }
    }

    private inner class InicioViewHolder(
        val binding: HistoryMainItemBinding,
        val context: Context
    ) : ViewHolderBase<User>(binding.root) {
        override fun bind(item: User) {
            Glide.with(context).load("${item.photo}").centerCrop().into(binding.imgCircleHistory)
        }

    }


}