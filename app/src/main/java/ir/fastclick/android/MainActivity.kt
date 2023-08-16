package ir.fastclick.android

import FastClick
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.homeText)
        val fastClick = FastClick.getInstance(this)
        MainScope().launch {
            val vastUrl = withContext(Dispatchers.IO) {
                fastClick.getVAST()
            }
            text.text = vastUrl
            Log.d(TAG, "onCreate: $vastUrl")
            if (vastUrl.isNotEmpty()) {
                Log.d(TAG, "onCreate: if $vastUrl")
            } else {
                Log.d(TAG, "onCreate: else $vastUrl")
            }
        }

    }
}