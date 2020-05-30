package com.github.aakira.hilt.ui.main

import android.content.Intent
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
import com.github.aakira.hilt.ui.second.SecondActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFirstFragment : Fragment(R.layout.fragment_first) {

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

        Log.d("first fragment", "app hash: $appHash")
        Log.d("first fragment", "activity hash: $activityHash")
        Log.d("first fragment", "fragment hash: $fragmentHash")
        Log.d("first fragment", "activity view model: $activityViewModel")
        Log.d("first fragment", "fragment view model: $fragmentViewModel")
        Log.d("first fragment", "activity vm repository: ${activityViewModel.getRepositoryHash()}")
        Log.d("first fragment", "fragment vm repository: ${fragmentViewModel.getRepositoryHash()}")

        button_activity.setOnClickListener {
            startActivity(Intent(activity, SecondActivity::class.java));
        }
        button_fragment.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
