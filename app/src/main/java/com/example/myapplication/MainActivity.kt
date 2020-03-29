package com.example.myapplication

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
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
        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play, 0, 0, 0)
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/raw/" + R.raw.video))

        playButton.setOnClickListener(View.OnClickListener {
            if(!videoView.isPlaying){
                val currentPos = videoView.currentPosition
                videoStartTime.setText(currentPos.toString())
                val videoDuration = videoView.duration
                videoEndTime.setText(videoDuration.toString())
                seekBar.max = videoDuration
                seekBar.setProgress(currentPos, true)
                videoView.start()
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0)
            }else{
                val currentPos = videoView.currentPosition
                videoStartTime.setText(currentPos.toString())
                val videoDuration = videoView.duration
                videoEndTime.setText(videoDuration.toString())
                seekBar.max = videoDuration
                seekBar.setProgress(currentPos, true)
                videoView.pause()
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play, 0, 0, 0)
            }
        })
    }
}
