package com.github.aakira.hilt.di.module

import com.github.aakira.hilt.di.qualifiers.AppHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @AppHash
    @Provides
    fun provideHash(): String {
        return hashCode().toString()
    }
}
