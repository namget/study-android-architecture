package com.namget.myarchitecture.ui.repo

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.namget.myarchitecture.R
import com.namget.myarchitecture.databinding.ActivityRepoBinding
import com.namget.myarchitecture.ext.obtainViewModeFactory
import com.namget.myarchitecture.ui.base.BaseActivity
import com.namget.myarchitecture.util.URL_REPO_DATA
import com.namget.myarchitecture.util.URL_USER_DATA

/**
 * Created by Namget on 2019.10.22.
 */
class RepoActivity : BaseActivity<ActivityRepoBinding>(R.layout.activity_repo) {

    private val viewModel by viewModels<RepoViewModel> { obtainViewModeFactory() }
    private lateinit var repoUrl: String
    private lateinit var userUrl: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        getIntentExtra()
        initBinding()
        requestUserData()
    }

    private fun initBinding(){
        binding.viewmodel = viewModel
    }


    private fun requestUserData() {
        if (::userUrl.isInitialized && ::repoUrl.isInitialized) {
            viewModel.requestUserData(userUrl, repoUrl)
        }
    }

    private fun getIntentExtra() {
        if (intent != null && intent.hasExtra(URL_REPO_DATA) && intent.hasExtra(URL_USER_DATA)) {
            repoUrl = intent.getStringExtra(URL_REPO_DATA)!!
            userUrl = intent.getStringExtra(URL_USER_DATA)!!
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}