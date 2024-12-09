package com.example.widgetdemo.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.widgetdemo.base.BaseViewBindingDialogFragment
import com.example.widgetdemo.databinding.DlgTipGuideBinding

class TipGuideDialogFragment: BaseViewBindingDialogFragment<DlgTipGuideBinding>() {

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = DlgTipGuideBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding.tvDtgOk.setOnClickListener {
            dismiss()
        }
    }
}