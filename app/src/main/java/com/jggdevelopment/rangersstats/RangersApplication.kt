package com.jggdevelopment.rangersstats

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.jggdevelopment.rangersstats.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RangersApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)

        startKoin {
            androidLogger()
            androidContext(this@RangersApplication)
            modules(appModule)
        }
    }
}
