package com.androiddevs.mvvmnewsapp.data.api

import com.androiddevs.mvvmnewsapp.const.Constanta.Companion.API_KEY
import com.androiddevs.mvvmnewsapp.data.model.MoviePopular
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviePopularApi {


    @GET("3/movie/popular")
    suspend fun getPopularMovie(
        @Query("language") language: String = "ru",
        @Query("page") page: Int = 1,
        @Query("Api_key") Api_key: String = API_KEY
    ): Response<MoviePopular>
}