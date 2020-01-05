package com.namget.myarchitecture.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.namget.myarchitecture.data.repository.RepoRepository
import com.namget.myarchitecture.ui.MyApplication
import com.namget.myarchitecture.util.ViewModelFactory

/**
 * Created by Namget on 2020.01.05.
 */
fun  AppCompatActivity.obtainViewModeFactory() : ViewModelFactory{
    val repository: RepoRepository = (application as MyApplication).repoRepository
    return ViewModelFactory(repository)
}