package com.example.deskswriter.di

import com.example.deskswriter.presentation.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    @Singleton
    fun inject(mainActivity: MainActivity)
}