package com.tw.myteste

import androidx.annotation.Nullable

/*
Baseado no site: https://www.calculator.net/bmi-calculator.html
*/

class Calculator(@Nullable private val height: String, @Nullable private val weight: String) {

    var imcValue = ""
    var imcValueText = ""

    fun calc() {

        if (height.isNotEmpty() and weight.isNotEmpty()) {

            val heightFloated = height.toFloat() / 100
            val weightFloated = weight.toFloat()

            val resultCalc = weightFloated / (heightFloated * heightFloated)

            imcValueText = categoria(resultCalc)

            imcValue = "%.2f".format(resultCalc)

        }else{
            println("Sem valores!!!")
        }
    }

    // Categoria  Faixa de IMC - kg / m 2
    fun categoria(res: Float) = when {
        res < 16 -> "Magreza Grave"
        res > 16 && res < 17 -> "Magreza moderada"
        res > 17 && res < 18.5 -> "Magreza leve"
        res > 18.5 && res < 25 -> "Normal"
        res > 25 && res < 30 -> "Excesso de peso"
        res > 30 && res < 35 -> "Obeso Classe I"
        res > 35 && res < 40 -> "Obeso Classe II"
        res > 40 -> "Obeso Classe II"

        else -> "sem dados"
    }

}