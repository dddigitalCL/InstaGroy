package com.example.instagroy.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ConcatHolderBase<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(adapter:T)
}