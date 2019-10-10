package me.rwosan.joiplayer.plugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent

class MainActivity : AppCompatActivity() {

    //Define intent extras
    var gameFolder = "" //Path of game folder as String
    var rgaPath = "" //Path of rga file as String
    var cKeyCode = KeyEvent.KEYCODE_C
    var xKeyCode = KeyEvent.KEYCODE_X
    var yKeyCode = KeyEvent.KEYCODE_Y
    var zKeyCode = KeyEvent.KEYCODE_Z
    var btnOpacity = "" //Gamepad button opacity as String
    var btnScale = "" //Gamepad button scale as String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Check if intent is null and get extras
        if (intent != null){
            if (intent.hasExtra("gameFolder")) gameFolder = intent.getStringExtra("gameFolder").orEmpty()
            if (intent.hasExtra("rgaPath")) rgaPath = intent.getStringExtra("rgaPath").orEmpty()
            if (intent.hasExtra("cKeyCode")) cKeyCode = intent.getIntExtra("cKeyCode",cKeyCode)
            if (intent.hasExtra("xKeyCode")) xKeyCode = intent.getIntExtra("xKeyCode",xKeyCode)
            if (intent.hasExtra("yKeyCode")) yKeyCode = intent.getIntExtra("yKeyCode",yKeyCode)
            if (intent.hasExtra("zKeyCode")) zKeyCode = intent.getIntExtra("zKeyCode",zKeyCode)
            if (intent.hasExtra("btnOpacity")) btnOpacity = intent.getStringExtra("btnOpacity").orEmpty()
            if (intent.hasExtra("btnScale")) btnScale = intent.getStringExtra("btnScale").orEmpty()
        }
    }
}
