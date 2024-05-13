package com.example.deskswriter

import android.app.Application
import com.example.deskswriter.di.AppComponent
import com.example.deskswriter.di.DaggerAppComponent
import com.example.deskswriter.di.DataModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder().dataModule(DataModule(applicationContext)).build()
    }
}