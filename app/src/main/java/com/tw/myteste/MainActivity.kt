package com.tw.myteste

import android.os.Bundle
import android.os.SystemClock
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// TODO Renomear para ChronomeActivity
class MainActivity : AppCompatActivity() {

    private var pauseOffSet: Long = 0
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
