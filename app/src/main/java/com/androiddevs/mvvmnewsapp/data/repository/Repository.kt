package com.androiddevs.mvvmnewsapp.data.repository

import com.androiddevs.mvvmnewsapp.data.api.RetrofitInstance

class Repository {

    suspend fun getPopularMovie(CountryLanguage: String, page: Int) =
        RetrofitInstance().api.getPopularMovie(CountryLanguage,page)
}
