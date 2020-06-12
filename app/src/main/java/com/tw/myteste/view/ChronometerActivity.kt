package com.tw.myteste.view

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.tw.myteste.R
import kotlinx.android.synthetic.main.activity_chrono.*


class ChronometerActivity : AppCompatActivity() {

    private var pauseOffSet: Long = 0
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrono)

        toggleButton.text = null
        toggleButton.textOff = null
        toggleButton.textOn = null

        toggleButton!!.setOnCheckedChangeListener { _, b ->

            if (b) {
                chronometer.base = SystemClock.elapsedRealtime() - pauseOffSet
                // chronometer.setCountDown(true)
                chronometer.start()
                isPlaying = true
            } else {
                chronometer.stop()
                pauseOffSet = SystemClock.elapsedRealtime() - chronometer.base
                isPlaying = false
            }
        }


        reset_btn.setOnClickListener {

                if (isPlaying) {
                    chronometer.base = SystemClock.elapsedRealtime()
                    pauseOffSet = 0 // 0
                    chronometer.start()
                    isPlaying = true
                }

        }



    }
}
