package za.co.absa.absatask.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AbsaApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}