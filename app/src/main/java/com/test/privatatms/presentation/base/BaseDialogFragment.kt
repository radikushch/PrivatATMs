package com.test.privatatms.presentation.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

abstract class  BaseDialogFragment : DialogFragment() {

    @LayoutRes
    abstract fun layout(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout(), container, false)
    }

    private var onFragmentCancelListener: DialogInterface.OnCancelListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is DialogInterface.OnCancelListener) {
            onFragmentCancelListener = context
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        onFragmentCancelListener?.onCancel(dialog)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(displayMetrics)
        val displayWidth = displayMetrics.widthPixels
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog?.window?.attributes)
        val dialogWindowWidth = (displayWidth * 0.9f).toInt()
        layoutParams.width = dialogWindowWidth
        dialog?.window?.attributes = layoutParams
    }
}
