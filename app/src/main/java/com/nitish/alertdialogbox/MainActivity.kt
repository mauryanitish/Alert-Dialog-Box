package com.nitish.alertdialogbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var tvValue:TextView?=null
    var button:Button?=null
    var number:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvValue = findViewById(R.id.tvValue)
        button = findViewById(R.id.button)

        button?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Change number press :")
                .setMessage("yes to increment 1, no to decrement 1, set-> 0")
                .setPositiveButton("Yes"){_,_->
                    number++
                    tvValue?.text=number.toString()
                }
                .setNegativeButton("No"){_,_->
                    number--
                    tvValue?.text=number.toString()
                }
                .setNeutralButton("Set 0"){_,_->
                    number=0
                    tvValue?.text = number.toString()
                }
                .setCancelable(false)
                .show()
        }
    }
}