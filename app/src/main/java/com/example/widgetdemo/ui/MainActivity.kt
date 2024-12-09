package com.example.widgetdemo.ui

import android.graphics.Color
import android.os.Bundle
import com.chad.library.adapter4.QuickAdapterHelper
import com.drake.statusbar.immersive
import com.drake.statusbar.statusPadding
import com.example.widgetdemo.R
import com.example.widgetdemo.adapter.WidgetAdapter
import com.example.widgetdemo.base.BaseActivity
import com.example.widgetdemo.bean.WidgetBean
import com.example.widgetdemo.databinding.ActivityMainBinding
import com.example.widgetdemo.dialog.TipGuideDialogFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mAdapter by lazy(LazyThreadSafetyMode.NONE) {
        WidgetAdapter(data)
    }

    private val helper by lazy(LazyThreadSafetyMode.NONE) {
        QuickAdapterHelper.Builder(mAdapter)
            .build()
    }

    override fun findViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersive(Color.TRANSPARENT, true)
        mViewBinding.viewAm.statusPadding()
        initData()
    }


    private fun initData() {
        mViewBinding.rvAm.adapter = helper.adapter
        mAdapter.setOnItemClickListener { adapter, _, position ->
            showGuide()
        }
    }


    private fun showGuide() {
        val dlg = TipGuideDialogFragment()
        dlg.show(supportFragmentManager, TipGuideDialogFragment::class.simpleName)
    }

    private val data: ArrayList<WidgetBean>
        get() = arrayListOf(
            WidgetBean(R.drawable.egg1, 0),
            WidgetBean(R.drawable.egg1, 0),
            WidgetBean(R.drawable.egg1, 1),
            WidgetBean(R.drawable.egg1, 2),
        )
}


