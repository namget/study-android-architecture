package com.namget.myarchitecture.ui.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.namget.myarchitecture.data.response.RepoInfoResponse
import com.namget.myarchitecture.data.response.UserInfoResponse
import com.namget.myarchitecture.data.source.MyResult
import com.namget.myarchitecture.domain.ReqRepoDataUseCase
import com.namget.myarchitecture.domain.ReqUserDataUseCase
import com.namget.myarchitecture.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Namget on 2019.12.01.
 */
class RepoViewModel(
    private val reqUserDataUseCase: ReqUserDataUseCase,
    private val reqRepoDataUseCase: ReqRepoDataUseCase
) : BaseViewModel() {
    private val _userInfo: MutableLiveData<UserInfoResponse> = MutableLiveData()
    val userInfo: LiveData<UserInfoResponse> get() = _userInfo
    private val _repoInfo: MutableLiveData<RepoInfoResponse> = MutableLiveData()
    val repoInfo: LiveData<RepoInfoResponse> get() = _repoInfo

    fun requestUserData(userUrl: String, repoUrl: String) = viewModelScope.launch {
        showLoading()
        val repo = reqRepoDataUseCase(repoUrl)
        val user = reqUserDataUseCase(userUrl)

        if (repo is MyResult.Success)
            _repoInfo.value = repo.data
        if (user is MyResult.Success)
            _userInfo.value = user.data
        hideLoading()
    }

    companion object {
        private const val TAG = "RepoViewModel"
    }


}