package com.androiddevs.mvvmnewsapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.const.Resource
import com.androiddevs.mvvmnewsapp.data.api.MoviePopularApi
import com.androiddevs.mvvmnewsapp.data.model.MoviePopular
import com.androiddevs.mvvmnewsapp.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel(var repository: Repository) : ViewModel() {


    val popularMovie: MutableLiveData<Resource<MoviePopular>> = MutableLiveData()
    val popularMoviePage = 1


    fun getPopularMovie(CountryLanguage: String) = viewModelScope.launch {
        popularMovie.postValue(Resource.Loading())
        val response = repository.getPopularMovie(CountryLanguage, popularMoviePage)
        popularMovie.postValue(handlePopularMovie(response))
    }

    private fun handlePopularMovie(response: Response<MoviePopular>): Resource<MoviePopular> {

        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())


    }


}