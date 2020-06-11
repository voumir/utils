package com.tw.myteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_imc.*

class ImcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btn.setOnClickListener {

            val calculator: Calculator =
                Calculator(height.text.toString(), weight.text.toString())

            calculator.calc()

            result.text = calculator.resultado
            resultText.text = calculator.resultadoText

        }

        btn_clear.setOnClickListener {
            height.text = null
            weight.text = null
            result.text = null
            resultText.text = null
        }


    }
}
