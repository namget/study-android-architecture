package com.namget.myarchitecture.ui.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.namget.myarchitecture.BR
import com.namget.myarchitecture.ext.hideKeyboard
import com.namget.myarchitecture.ext.showKeyboard
import com.namget.myarchitecture.ext.showToast
import com.namget.myarchitecture.util.Injection
import com.namget.myarchitecture.util.ViewModelFactory
import kotlin.reflect.KClass

/**
 * Created by Namget on 2019.10.23.
 */
abstract class BaseActivity<B : ViewDataBinding, VM : KClass<BaseViewModel>>(
    @LayoutRes
    val layoutRes: Int
) :
    AppCompatActivity() {
    protected val viewModel by viewModels<VM> { ViewModelFactory.getInstance(this.application) }
    protected open lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.setVariable(BR.viewmodel, viewModel)
    }

    protected val toast: (Int) -> Unit = {
        showToast(it)
    }

    protected val keyBoard: (Boolean) -> Unit = {
        if (it) showKeyboard() else hideKeyboard()
    }

    override fun onDestroy() {
        viewModel.unSubscribe()
        super.onDestroy()
    }

}