package com.github.aakira.hilt.ui.second

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.aakira.hilt.R
import com.github.aakira.hilt.data.SampleRepository
import com.github.aakira.hilt.di.qualifiers.ActivityHash
import com.github.aakira.hilt.di.qualifiers.AppHash
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    @AppHash
    @Inject
    lateinit var appHash: String

    @ActivityHash
    @Inject
    lateinit var activityHash: String

    @Inject
    lateinit var repository: SampleRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.w("second activity", "app hash: $appHash")
        Log.w("second activity", "activity hash: $activityHash")
        Log.v("second activity", "repository hash: $repository")
    }
}
