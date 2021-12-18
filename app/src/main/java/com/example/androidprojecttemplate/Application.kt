package com.example.androidprojecttemplate

import com.example.androidprojecttemplate.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@Application)
            modules(
                listOf(
                    appModule,
                    useCaseModule,
                    apiModule,
                    dataSourceModule,
                    repoModule
                )
            )
        }
    }
}