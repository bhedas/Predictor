package com.example.predictor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View
import android.media.MediaPlayer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mediaPlayer :MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val predict=findViewById<Button>(R.id.predict)
        val ValueR=findViewById<TextView>(R.id.valuer)
        val ValueJ=findViewById<TextView>(R.id.valuej)
        val romeo=findViewById<EditText>(R.id.romeotext)
        val juliet=findViewById<EditText>(R.id.juliettext)
        val value_romeo:String=romeo.text.toString()
        val value_juliet:String=juliet.text.toString()
        predict.setOnClickListener(){
           onstoping()
           prediction(it)
            if (ValueR.getText().toString().equals("") || ValueJ.getText().toString().equals("")) {
                predict.isEnabled = true
            }
            else{
                predict.isEnabled = false
            }
        }
        ValueR.setOnClickListener(){
            textviewR_hide(it)
            predict.isEnabled=true
            ValueR.setText("")
        }
        ValueJ.setOnClickListener(){
            textviewJ_hide(it)
            predict.isEnabled=true
            ValueJ.setText("")
        }

    }
    private fun prediction(view:View){
        val romeo=findViewById<EditText>(R.id.romeotext)
        val juliet=findViewById<EditText>(R.id.juliettext)
        val ValueR=findViewById<TextView>(R.id.valuer)
        val ValueJ=findViewById<TextView>(R.id.valuej)
        val result=findViewById<TextView>(R.id.result)
        val value_romeo:String=romeo.text.toString()
        val value_juliet:String=juliet.text.toString()
        if (value_romeo.isEmpty() || value_juliet.isEmpty()){
            result.setText(" Name not added")
            predict.isEnabled=true
        }
        else{
            val randomno=(0..100).random().toString()
            result.setText(randomno+"%")
            romeo.visibility=View.GONE
            juliet.visibility=View.GONE
            ValueJ.setText(value_juliet)
            ValueR.setText(value_romeo)
            ValueJ.visibility=View.VISIBLE
            ValueR.visibility=View.VISIBLE

            if(randomno.toInt()<11){
                mediaPlayer= MediaPlayer.create(this, R.raw.channa)
                mediaPlayer?.start()
            }
            if(10<randomno.toInt() && randomno.toInt()<50){
                mediaPlayer = MediaPlayer.create(this, R.raw.dhoka)
                mediaPlayer?.start()
            }
            if(49<randomno.toInt() && randomno.toInt()<80){
                mediaPlayer = MediaPlayer.create(this, R.raw.osathi)
                mediaPlayer?.start()
            }
            if(randomno.toInt()>79){
                mediaPlayer = MediaPlayer.create(this, R.raw.tumhi)
                mediaPlayer?.start()
            }

        }
    }
    private fun textviewR_hide(view: View){
        val romeo=findViewById<EditText>(R.id.romeotext)
        val ValueR=findViewById<TextView>(R.id.valuer)
        romeo.setText("")
        romeo.visibility=View.VISIBLE
        ValueR.visibility=View.GONE

    }
    private fun textviewJ_hide(view: View){
        val juliet=findViewById<EditText>(R.id.juliettext)
        val ValueJ=findViewById<TextView>(R.id.valuej)
        juliet.setText("")
        juliet.visibility=View.VISIBLE
        ValueJ.visibility=View.GONE

    }
    private fun onstoping(){
        if(mediaPlayer!=null){
            mediaPlayer?.stop()
        }
    }



}
