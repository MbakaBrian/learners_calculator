package com.example.learners_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.EditText
import org.w3c.dom.Text
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var Button0:android.widget.Button
    lateinit var Button1:android.widget.Button
    lateinit var Button2:android.widget.Button
    lateinit var Button3:android.widget.Button
    lateinit var Button4:android.widget.Button
    lateinit var Button5:android.widget.Button
    lateinit var Button6:android.widget.Button
    lateinit var Button7:android.widget.Button
    lateinit var Button8:android.widget.Button
    lateinit var Button9:android.widget.Button
    lateinit var Button00:android.widget.Button
    lateinit var Button_divide:android.widget.Button
    lateinit var Button_multiply:android.widget.Button
    lateinit var Button_subtract:android.widget.Button
    lateinit var Button_add:android.widget.Button
    lateinit var Button_percent:android.widget.Button
    lateinit var Button_decimal:android.widget.Button
    lateinit var Button_equal:android.widget.Button
    lateinit var Button_erase:android.widget.Button
    lateinit var Button_clear:android.widget.Button
    lateinit var edt_entry:EditText
    lateinit var edt_answer:EditText


    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        Button0=findViewById(R.id.btn_0)
        Button00=findViewById(R.id.btn_00)
        Button1=findViewById(R.id.btn_1)
        Button2=findViewById(R.id.btn_2)
        Button3=findViewById(R.id.btn_3)
        Button4=findViewById(R.id.btn_4)
        Button5=findViewById(R.id.btn_5)
        Button6=findViewById(R.id.btn_6)
        Button7=findViewById(R.id.btn_7)
        Button8=findViewById(R.id.btn_8)
        Button9=findViewById(R.id.btn_9)
        Button_add=findViewById(R.id.btn_add)
        Button_multiply=findViewById(R.id.btn_product)
        Button_divide=findViewById(R.id.btn_divide)
        Button_subtract=findViewById(R.id.btn_subtract)
        Button_percent=findViewById(R.id.btn_percent)
        Button_decimal=findViewById(R.id.btn_decimal)
        Button_erase=findViewById(R.id.btn_erace)
        Button_clear=findViewById(R.id.btn_clear)
        Button_equal=findViewById(R.id.btn_equal)
        edt_entry=findViewById(R.id.edt_entry)
        edt_answer=findViewById(R.id.edt_answ)


        edt_entry.movementMethod=ScrollingMovementMethod()
        edt_entry.setActivated(true)
        edt_entry.setPressed(true)


        var text: String

        Button0.setOnClickListener {
            text=edt_entry.text.toString()+"0"
            edt_entry.setText(text)
            result(text)
        }

        Button00.setOnClickListener {
            text=edt_entry.text.toString()+"00"
            edt_entry.setText(text)
            result(text)
        }
        Button1.setOnClickListener {
            text=edt_entry.text.toString()+"1"
            edt_entry.setText(text)
            result(text)
        }
        Button2.setOnClickListener {
            text=edt_entry.text.toString()+"2"
            edt_entry.setText(text)
            result(text)
        }

        Button3.setOnClickListener {
            text=edt_entry.text.toString()+"3"
            edt_entry.setText(text)
            result(text)
        }

        Button4.setOnClickListener {
            text=edt_entry.text.toString()+"4"
            edt_entry.setText(text)
            result(text)
        }

        Button5.setOnClickListener {
            text=edt_entry.text.toString()+"5"
            edt_entry.setText(text)
            result(text)
        }

        Button6.setOnClickListener {
            text=edt_entry.text.toString()+"6"
            edt_entry.setText(text)
            result(text)
        }

        Button7.setOnClickListener {
            text=edt_entry.text.toString()+"7"
            edt_entry.setText(text)
            result(text)
        }

        Button8.setOnClickListener {
            text=edt_entry.text.toString()+"8"
            edt_entry.setText(text)
            result(text)
        }

        Button9.setOnClickListener {
            text=edt_entry.text.toString()+"9"
            edt_entry.setText(text)
            result(text)
        }

        Button_decimal.setOnClickListener {
            text=edt_entry.text.toString()+"."
            edt_entry.setText(text)
            result(text)
        }

        Button_add.setOnClickListener {
            text=edt_entry.text.toString()+"+"
            edt_entry.setText(text)
            check=check+1
        }

        Button_subtract.setOnClickListener {
            text=edt_entry.text.toString()+"-"
            edt_entry.setText(text)
            check=check+1
        }

        Button_divide.setOnClickListener {
            text=edt_entry.text.toString()+"/"
            edt_entry.setText(text)
            check=check+1
        }

        Button_multiply.setOnClickListener {
            text=edt_entry.text.toString()+"*"
            edt_entry.setText(text)
            check=check+1
        }

        Button_percent.setOnClickListener {
            text=edt_entry.text.toString()+"%"
            edt_entry.setText(text)
            check=check+1
        }

        Button_equal.setOnClickListener {
            text=edt_answer.text.toString()
            edt_entry.setText(text)
            edt_answer.setText(null)
        }
        Button_clear.setOnClickListener {
            edt_entry.setText(null)
            edt_answer.setText(null)
        }


        Button_erase.setOnClickListener {
            var Backspace :String?=null
            if (edt_entry.text.length>0){
                val stringBuilder:StringBuilder= StringBuilder(edt_entry.text)
                val find=edt_entry.text.toString()
                val find2=find.last()

                if (find2.equals('+') and find2.equals('-') and find2.equals('/') and find2.equals('*') and find2.equals('%') ){
                    check=check-1
                }
                stringBuilder.deleteCharAt(edt_entry.text.length-1)
                Backspace=stringBuilder.toString()
                edt_entry.setText(Backspace)
                result(Backspace)
            }

        }
    }

    private fun result(text: String) {


        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")

        try{
            val result : Any=engine.eval(text)
            var mainr=result.toString()
            if (check==0){
                edt_answer.setText(null)
            }else{
                edt_answer.setText(mainr)
            }
        }
        catch (e : ScriptException){

        }
    }
}