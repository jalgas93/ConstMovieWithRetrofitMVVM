package com.androiddevs.mvvmnewsapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.data.repository.Repository

class ViewModelProviderFactory(var repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return MovieViewModel(repository) as T
    }
}