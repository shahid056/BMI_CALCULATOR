package com.example.bmicalculator


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.TextView
import kotlin.math.abs

class Result : AppCompatActivity() {


    private lateinit var bmi : TextView
    private  lateinit var cate : TextView
    private lateinit var categocard : CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        bmi = findViewById(R.id.result)
        cate = findViewById(R.id.catergories)
        categocard = findViewById(R.id.cardcategories)

        val weight = intent.getStringExtra("weight")
        val height = intent.getStringExtra("height")



     val result = (abs(weight?.toFloat()?.div(((height?.toFloat()?.div(100))!! * (height?.toFloat()/100) ))!!).toFloat()).toString()
      bmi.text = result

        if(result.toFloat()<18.5){
            cate.text = "UNDER WEIGHT"
            categocard.setCardBackgroundColor(Color.BLUE)

        }
        else if(result.toFloat()>18.5 && result.toFloat()<24.9){
            cate.text = "NORMAL WEIGHT"
            categocard.setCardBackgroundColor(Color.GREEN)
        }
        else if(result.toFloat()>25.0 && result.toFloat()<29.9){
            cate.text = "OVER WEIGHT"
            categocard.setCardBackgroundColor(Color.YELLOW)
        }
        else{
            cate.text = "OBESE"
            categocard.setCardBackgroundColor(Color.RED)
        }




    }
}