package com.example.instagroy.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.example.instagroy.R
import com.example.instagroy.core.Resource
import com.example.instagroy.data.local.AppDatabase
import com.example.instagroy.data.local.LocalUserDataSource
import com.example.instagroy.data.model.User
import com.example.instagroy.databinding.FragmentPantallaInicioBinding
import com.example.instagroy.presentation.InicioViewModel
import com.example.instagroy.presentation.InicioViewModelFactory
import com.example.instagroy.repository.UserRepositoryImpl
import com.example.instagroy.ui.adapter.HistoryAdapter
import com.example.instagroy.ui.adapter.ViewHistory


class pantallaInicio : Fragment(R.layout.fragment_pantalla_inicio), ViewHistory.OnHistoryClickListener {

    private lateinit var binding: FragmentPantallaInicioBinding
    private val viewModel by viewModels<InicioViewModel> {
        InicioViewModelFactory(
            UserRepositoryImpl(
                LocalUserDataSource(AppDatabase.getDatabase(requireContext()).userDao())
            )
        )
    }

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPantallaInicioBinding.bind(view)
        concatAdapter = ConcatAdapter()

        viewModel.fetchUsers().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("livedata", "Loading")
                }
                is Resource.Success -> {
                    concatAdapter.apply {
                        addAdapter(0, HistoryAdapter(ViewHistory(result.data.mutableUser,this@pantallaInicio)))
                    }
                    binding.rvHistoryMain.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    Log.d("error", "${result.exception}")
                }
            }
        })

    }

    override fun onHistoryClick(user: User) {
        Log.d("persona","Clickado $user")
    }




}
