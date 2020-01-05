package com.namget.myarchitecture.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Namget on 2019.10.23.
 */
abstract class BaseActivity<B : ViewDataBinding>(
    @LayoutRes
    val layoutRes: Int
) : AppCompatActivity() {

    protected open lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }



}