package ir.fastclick.android

import FastClick
import android.app.Application
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppController : Application() {

    companion object {
        private const val TAG = "AppController"
    }

    lateinit var fastClick: FastClick

    override fun onCreate() {
        super.onCreate()
        fastClick = FastClick.getInstance(this)
    }

}