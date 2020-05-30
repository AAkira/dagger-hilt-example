package com.github.aakira.hilt.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.aakira.hilt.R
import com.github.aakira.hilt.data.SampleRepository
import com.github.aakira.hilt.di.qualifiers.ActivityHash
import com.github.aakira.hilt.di.qualifiers.AppHash
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @AppHash
    @Inject
    lateinit var appHash: String

    @ActivityHash
    @Inject
    lateinit var activityHash: String

    @Inject
    lateinit var repository: SampleRepository

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v("main activity", "app hash: $appHash")
        Log.v("main activity", "activity hash: $activityHash")
        Log.v("main activity", "repository hash: $repository")
        Log.v("main activity", "activity view model: $viewModel")
        Log.v("main activity", "activity vm repository: ${viewModel.getRepositoryHash()}")
    }
}
