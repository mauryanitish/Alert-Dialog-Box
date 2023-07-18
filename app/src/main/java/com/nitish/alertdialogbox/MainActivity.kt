package com.nitish.alertdialogbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var tvValue:TextView?=null
    var buttonAlert:Button?=null
    var buttonSimpleList:Button?=null
    var buttonMuliSelectedList:Button?=null
    var buttonCustom:Button?=null
    var tvCustom:TextView?=null
    var simpleArray= arrayOf("Blue","Black","Red","Green")
    var boolArrayList= booleanArrayOf(false,false,false,false)
    var number:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvValue = findViewById(R.id.tvValue)
        buttonAlert = findViewById(R.id.buttonAlert)
        buttonSimpleList = findViewById(R.id.buttonSimpleList)
        buttonMuliSelectedList = findViewById(R.id.buttonMultiList)
        buttonCustom = findViewById(R.id.buttonCustomAlert)
        tvCustom = findViewById(R.id.tvCustom)

        buttonAlert?.setOnClickListener {
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
        buttonSimpleList?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Select Color")
                .setItems(simpleArray){_,position->
                    Toast.makeText(this,"Selected ${simpleArray[position]}",Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        buttonMuliSelectedList?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Select Multiple Colors")
                .setMultiChoiceItems(simpleArray,boolArrayList){_, postion,ischecked->
                    Toast.makeText(this,"position $postion isChecked $ischecked",Toast.LENGTH_SHORT).show()
                    println("position $postion isChecked $ischecked")
                }
                .setPositiveButton("Ok"){_,_->
                    var selectedColor=""
                    for (i in 0..boolArrayList.size-1){
                        if (boolArrayList[i]==true){
                            selectedColor=selectedColor+simpleArray[i]+" "
                        }
                    }
                    buttonMuliSelectedList?.setText(selectedColor)
                }
                .show()
        }
        buttonCustom?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.show()
            var btnSubmit:Button = dialog.findViewById(R.id.buttonSubmit)
            var etFeedBack:EditText = dialog.findViewById(R.id.etFeedBack)

            btnSubmit.setOnClickListener {
                if (etFeedBack.text.toString().isNullOrEmpty()){
                    etFeedBack.error="Enter your feedback"
                }
                else{
                    tvCustom?.setText(etFeedBack.text.toString())
                    dialog.dismiss()
                }
            }
        }
    }
}