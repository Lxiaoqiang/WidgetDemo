package com.example.widgetdemo.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding>: FragmentActivity() {

    protected lateinit var mViewBinding: VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = findViewBinding() as VB
        setContentView(mViewBinding.root)
    }

    abstract fun findViewBinding(): ViewBinding
}