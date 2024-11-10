package com.bit2b.gear

import android.app.Application
import com.bit2b.gear.di.appModule
import com.bit2b.gear.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule,
                retrofitModule
            )
        }
    }
}