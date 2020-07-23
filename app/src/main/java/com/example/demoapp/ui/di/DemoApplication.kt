package com.example.demoapp.ui.di

import android.app.Application
import com.example.demoapp.data.dataModule
import com.example.demoapp.domain.domainModule
import com.example.demoapp.ui.di.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // use AndroidLogger as Koin Logger - default Level.INFO
            androidLogger()

            // use the Android context given there
            androidContext(this@DemoApplication)

            // load properties from assets/koin.properties file
            androidFileProperties()

            // module list
            modules(dataModule, domainModule, appModule)
        }
    }
}