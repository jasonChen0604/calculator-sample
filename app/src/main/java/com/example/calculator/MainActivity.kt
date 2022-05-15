package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val editText : EditText by lazy { findViewById(R.id.editText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onViewClick(view: View){
        val textView = view as TextView

        val inputText = textView.text
        val allText = editText.text.toString()

        when(inputText){
            "C" -> editText.setText("")
            "÷","+","-","×","%" -> {
                // 取得allText最後一個字元
                // 判斷是不是符號
                // 如果不是 就加上去
                // 如果是 替換最後一個字為新的符號
                editText.setText("$allText$inputText")
            }
            "()" -> {}
            "=" -> {
                val list = allText.split("÷","+","-","×","%", ignoreCase = true)
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("result",allText)
                startActivity(intent)
            }
            else -> editText.setText("$allText$inputText")
        }
    }
}