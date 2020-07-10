package com.maxtayler.punk.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import timber.log.Timber

open class BaseFragment : Fragment {

    constructor() : super()
    constructor(@LayoutRes layout: Int) : super(layout)

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        Timber.v("onActivityResult")
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        Timber.v("onCreateView")
        return view
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.v("onViewCreated")
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        Timber.v("onResume")
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        Timber.v("onPause")
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.v("onDestroyView")
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        Timber.v("onDestroy")
    }

    @CallSuper
    override fun onDetach() {
        super.onDetach()
        Timber.v("onDetach")
    }
}
