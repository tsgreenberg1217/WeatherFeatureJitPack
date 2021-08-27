package com.example.weatherapplibrary.fragments
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.weatherapplibrary.R
import com.example.weatherapplibrary.baseClasses.BaseFragment
import com.example.weatherapplibrary.databinding.Fragment12Binding
import com.example.weatherapplibrary.viewmodels.HEADER
import com.example.weatherapplibrary.viewmodels.HeadersViewModel


class Fragment_1_2 : BaseFragment(R.layout.fragment_1_2) {
    private val headerViewModel: HeadersViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Fragment12Binding.bind(view)
        Fragment12Binding.bind(view).frag12Btn.setOnClickListener {
            headerViewModel.navigateToHeader(HEADER.TWO)
        }

    }
}