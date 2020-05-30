package com.github.aakira.hilt.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.aakira.hilt.data.SampleRepository

class MainViewModel @ViewModelInject constructor(
    private val repository: SampleRepository,
    @Assisted private val savedState: SavedStateHandle
) : ViewModel() {

    fun getRepositoryHash(): String = repository.toString()
}
