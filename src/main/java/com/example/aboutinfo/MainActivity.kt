package com.example.aboutinfo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName= MyName("Ritik Puri")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName= myName
        binding.donebutton.setOnClickListener{
            nicknameadd(it)
        }
    }

    private fun nicknameadd(view: View)
    {
        val edittext = findViewById<EditText>(R.id.nickname_edit)
        val nicktext= findViewById<TextView>(R.id.nicknametext)
        binding.apply {
            myName?.nickname=nicknameEdit.text.toString()
            nicktext.text = edittext.text
            invalidateAll()
            edittext.visibility = View.GONE
            view.visibility = View.GONE
            nicktext.visibility = View.VISIBLE
        }
        //Hide the keyboard after we are done

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}