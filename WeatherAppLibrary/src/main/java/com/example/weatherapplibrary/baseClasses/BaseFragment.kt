package com.example.weatherapplibrary.baseClasses

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment(layoutId:Int):Fragment(layoutId){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FRAGMENT LOG", "creating ${this.javaClass.simpleName}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        Log.d("FRAGMENT LOG", "destroying ${this.javaClass.simpleName}")
        super.onDestroy()
    }
}