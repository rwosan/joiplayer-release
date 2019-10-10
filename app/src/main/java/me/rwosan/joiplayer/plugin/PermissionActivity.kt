package me.rwosan.joiplayer.plugin

import androidx.core.app.ActivityCompat
import android.content.Intent
import androidx.core.content.ContextCompat
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity


class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        //Check if sdk int is greater than 23 and WRITE_EXTERNAL_STORAGE permission is not granted.
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(
                this,
                "android.permission.WRITE_EXTERNAL_STORAGE"
            ) != 0
        ) {
            //Request WRITE_EXTERNAL_STORAGE permission.
            ActivityCompat.requestPermissions(
                this,
                arrayOf("android.permission.WRITE_EXTERNAL_STORAGE"),
                12
            )
        } else {
            //If permission is granted, start MainActivity.
            if (intent != null && intent.extras != null) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtras(intent.extras!!)
                startActivity(i)
            }
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        /**If request code is same with permission request and WRITE_EXTERNAL_STORAGE permission is
         * granted, start MainActivity. If WRITE_EXTERNAL_STORAGE permission is not granted, request
         * it again.
         */

        if (requestCode == 12 && ContextCompat.checkSelfPermission(
                this,
                "android.permission.WRITE_EXTERNAL_STORAGE"
            ) == 0
        ) {
            if (intent != null && intent.extras != null) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtras(intent.extras!!)
                startActivity(i)
            }

        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf("android.permission.WRITE_EXTERNAL_STORAGE"),
                12
            )
        }
    }
}