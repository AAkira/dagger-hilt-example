package com.github.aakira.hilt.di.module

import com.github.aakira.hilt.di.qualifiers.FragmentHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {
    @FragmentHash
    @Provides
    fun provideHash(): String {
        return hashCode().toString()
    }
}
