package com.example.weatherapplibrary

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.weatherapplibrary.databinding.ActivityMainBinding
import com.example.weatherapplibrary.viewmodels.HEADER
import com.example.weatherapplibrary.viewmodels.HeadersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainHeaderActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding

    private val headersViewModel: HeadersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        headersViewModel.highlightedHeader.observe(this) {
            when (it) {
                HEADER.ONE -> setUpOne()
                HEADER.TWO -> setUpTwo()
                else -> setUpOne()
            }
        }
        setContentView(mainActivityBinding.root)
    }

    private fun getNavForContainer(container: FragmentContainerView): NavController {
        return (supportFragmentManager.findFragmentById(container.id) as NavHostFragment).navController
    }

    private fun setUpOne() {
        getNavForContainer(mainActivityBinding.header1FragmentContainer).apply {
            navigate(R.id.action_blankFragment_to_fragment_1_dest)
        }
    }

    private fun setUpTwo() {
        getNavForContainer(mainActivityBinding.header1FragmentContainer).apply {
            popBackStack(R.id.blankFragment, false)
        }
        getNavForContainer(mainActivityBinding.header2FragmentContainer).apply {
            navigate(R.id.action_blankFragment2_to_fragment_2_dest)
        }

    }
}