package com.example.bmicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private  lateinit var groupradiobtn : RadioGroup
    private  lateinit var btnradio : RadioButton
    private lateinit var btnshare : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupradiobtn = findViewById(R.id.groupradio);
        btnshare = findViewById(R.id.share)
        val btncal = findViewById<Button>(R.id.button)

        val weightnum = findViewById<TextView>(R.id.weightincre)
        val heightnum = findViewById<TextView>(R.id.height1)
        val agenum = findViewById<TextView>(R.id.age2)

        btncal.setOnClickListener {


                if (weightnum.text.isNotEmpty() && heightnum.text.isNotEmpty() && agenum.text.isNotEmpty() ) {

                    val data = Intent(this, Result::class.java)
                        .putExtra("weight", weightnum.text.toString())
                        .putExtra("height", heightnum.text.toString())
                    startActivity(data)

                }
            else {


                Toast.makeText(this, "Enter all the field", Toast.LENGTH_LONG).show()

            }
        }



        btnshare.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.setType("text/plain")
            share.putExtra(Intent.EXTRA_TEXT,"Download This Amazing App Help To Calculate Your BMI, www.google.com")
            startActivity(share)
        }

    }
    }
