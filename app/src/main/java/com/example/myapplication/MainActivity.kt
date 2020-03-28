package com.example.myapplication

import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.MediaController
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     darkModeSwitch.setOnCheckedChangeListener{ CompoundButton, isChecked ->
         if (isChecked){
             delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)
         }else{
             delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
         }
     }
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/raw/" + R.raw.video))
        videoView.start()

    }
}
