package com.tw.myteste.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tw.myteste.model.Calculator
import com.tw.myteste.R
import kotlinx.android.synthetic.main.activity_imc.*

class ImcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btn.setOnClickListener {

            val calculator: Calculator =
                Calculator(
                    height.text.toString(),
                    weight.text.toString()
                )

            calculator.calc() // TODO refazer como init

            result.text = calculator.imcValue
            resultText.text = calculator.imcValueText

        }

        btn_clear.setOnClickListener {
            height.text = null
            weight.text = null
            result.text = null
            resultText.text = null
        }


    }
}
