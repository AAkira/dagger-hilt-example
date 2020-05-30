package com.github.aakira.hilt.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.aakira.hilt.R
import com.github.aakira.hilt.di.qualifiers.ActivityHash
import com.github.aakira.hilt.di.qualifiers.AppHash
import com.github.aakira.hilt.di.qualifiers.FragmentHash
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_second.*
import javax.inject.Inject

@AndroidEntryPoint
class MainSecondFragment : Fragment(R.layout.fragment_second) {

    @AppHash
    @Inject
    lateinit var appHash: String

    @ActivityHash
    @Inject
    lateinit var activityHash: String

    @FragmentHash
    @Inject
    lateinit var fragmentHash: String

    private val activityViewModel by activityViewModels<MainViewModel>()
    private val fragmentViewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("second fragment", "app hash: $appHash")
        Log.i("second fragment", "activity hash: $activityHash")
        Log.i("second fragment", "fragment hash: $fragmentHash")
        Log.i("second fragment", "activity view model: $activityViewModel")
        Log.i("second fragment", "fragment view model: $fragmentViewModel")
        Log.i("second fragment", "activity vm repository: ${activityViewModel.getRepositoryHash()}")
        Log.i("second fragment", "fragment vm repository: ${fragmentViewModel.getRepositoryHash()}")

        button.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
