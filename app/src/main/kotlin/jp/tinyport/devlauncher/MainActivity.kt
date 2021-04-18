package jp.tinyport.devlauncher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS))
        finish()
    }
}
