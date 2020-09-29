package com.androiddevs.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.ViewModel.MovieViewModel
import com.androiddevs.mvvmnewsapp.ViewModel.ViewModelProviderFactory
import com.androiddevs.mvvmnewsapp.data.repository.Repository
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel:MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         var repository = Repository()
        var viewModelProviderFactory =ViewModelProviderFactory(repository)
            mViewModel = ViewModelProvider(this,viewModelProviderFactory).get(MovieViewModel::class.java)

              bottomNavigationView.setupWithNavController(fragment_main_activity.findNavController())

    }
}
