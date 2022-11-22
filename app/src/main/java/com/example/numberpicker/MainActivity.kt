package com.example.numberpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val btSetNum by lazy {findViewById<Button>(R.id.btSetNum)}
    private val btUnlock by lazy {findViewById<Button>(R.id.btUnlock)}
    private val np1 by lazy {findViewById<NumberPicker>(R.id.np1)}
    private val np2 by lazy {findViewById<NumberPicker>(R.id.np2)}
    private val np3 by lazy {findViewById<NumberPicker>(R.id.np3)}
    private val np4 by lazy {findViewById<NumberPicker>(R.id.np4)}
    private var passwd = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNp(np1)
        setNp(np2)
        setNp(np3)
        setNp(np4)
        setupUiListener()

    }

    fun setNp(np:NumberPicker){
        np.minValue=0
        np.maxValue=9
    }

    fun showMsg(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun setupUiListener()
    {
        btSetNum.setOnClickListener {
            passwd=np1.value*1000 + np2.value*100 + np3.value*10 + np4.value
            showMsg(getString(R.string.passwd_set))
        }
        btUnlock.setOnClickListener {
            if (passwd <0){
                showMsg(getString(R.string.passwd_not_set))
                return@setOnClickListener
            }
            val num =np1.value*1000 + np2.value*100 + np3.value*10 + np4.value
            if (num == passwd){
                showMsg(getString(R.string.correct))
            }
            else  showMsg(getString(R.string.error))
        }
    }
}