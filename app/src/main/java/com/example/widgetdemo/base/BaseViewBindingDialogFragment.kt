package com.example.widgetdemo.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.example.widgetdemo.R

abstract class BaseViewBindingDialogFragment<VB: ViewBinding>: DialogFragment() {
    private var _binding: VB? = null

    protected open lateinit var mViewBinding: VB

    override fun onStart() {
        super.onStart()
        if(activity == null || requireActivity().isFinishing)
            return
        dialog?.setCancelable(cancelable())
        dialog?.setCanceledOnTouchOutside(cancelOutside())
        val window = dialog?.window
        val wlp = window?.attributes
        wlp?.width = width()
        wlp?.height = height()
        wlp?.dimAmount = disAmount()
        window?.attributes = wlp
        window?.setGravity(setGravity())
        window?.setWindowAnimations(setWindowAnimations())
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            window?.navigationBarColor = Color.TRANSPARENT
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container) as VB
        mViewBinding = _binding!!
        return _binding!!.root
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            //fix Can not perform this action after onSaveInstanceState
            super.show(manager, tag)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding

    protected open fun width(): Int = ViewGroup.LayoutParams.MATCH_PARENT

    protected open fun height(): Int = ViewGroup.LayoutParams.WRAP_CONTENT

    protected open fun cancelable(): Boolean = true

    protected open fun cancelOutside() = true

    protected open fun disAmount(): Float = 0.5F

    protected open fun setGravity(): Int = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL

    protected open fun setWindowAnimations(): Int = R.style.dialog_animation

    fun isShowing() = dialog != null && dialog!!.isShowing
}