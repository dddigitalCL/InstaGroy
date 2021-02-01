package com.example.instagroy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagroy.R
import com.example.instagroy.core.ConcatHolderBase
import com.example.instagroy.databinding.FragmentPantallaInicioBinding

class HistoryAdapter(private val viewHistory: ViewHistory) : RecyclerView.Adapter<ConcatHolderBase<*>>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcatHolderBase<*> {
        val itemBinding = FragmentPantallaInicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ConcatHolderBase<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(viewHistory)
        }
    }

    private inner class ConcatViewHolder(val binding: FragmentPantallaInicioBinding): ConcatHolderBase<ViewHistory>(binding.root){
        override fun bind(adapter: ViewHistory) {
           binding.rvHistoryMain.adapter = adapter
        }
    }

}