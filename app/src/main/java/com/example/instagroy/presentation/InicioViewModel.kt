package com.example.instagroy.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.instagroy.core.Resource
import com.example.instagroy.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class InicioViewModel(private val repo: UserRepository): ViewModel() {


    fun fetchUsers() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repo.getUsers()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class InicioViewModelFactory(private val repo:UserRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(UserRepository::class.java).newInstance(repo)
    }
}