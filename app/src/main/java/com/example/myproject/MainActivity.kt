package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myproject.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnAc:Button
    private lateinit var btnBack:Button
    private lateinit var btn0:Button
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var btnAdd:Button
    private lateinit var btnSub:Button
    private lateinit var btnMul:Button
    private lateinit var btnDiv:Button
    private lateinit var btnDot:Button
    private lateinit var btnEqual:Button
    private lateinit var btnFirst:Button
    private lateinit var btnSecond:Button
    private lateinit var inputTextView:TextView
    private lateinit var outputTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFindView()
        setButton()
    }

    private fun setButton() {
        // number
        btn0.setOnClickListener {
            setOnClickLickListener("0", true)
        }
        btn1.setOnClickListener {
            setOnClickLickListener("1", true)
        }
        btn2.setOnClickListener {
            setOnClickLickListener("2", true)
        }
        btn3.setOnClickListener {
            setOnClickLickListener("3", true)
        }
        btn4.setOnClickListener {
            setOnClickLickListener("4", true)
        }
        btn5.setOnClickListener {
            setOnClickLickListener("5", true)
        }
        btn6.setOnClickListener {
            setOnClickLickListener("6", true)
        }
        btn7.setOnClickListener {
            setOnClickLickListener("7", true)
        }
        btn8.setOnClickListener {
            setOnClickLickListener("8", true)
        }
        btn9.setOnClickListener {
            setOnClickLickListener("9", true)
        }
        btnDot.setOnClickListener {
            setOnClickLickListener(".", true)
        }
        // operator
        btnAdd.setOnClickListener {
            setOnClickLickListener("+", false)
        }
        btnSub.setOnClickListener {
            setOnClickLickListener("-", false)
        }
        btnMul.setOnClickListener {
            setOnClickLickListener("*", true)
        }
        btnDiv.setOnClickListener {
            setOnClickLickListener("/", true)
        }
        btnFirst.setOnClickListener {
            setOnClickLickListener("(", true)
        }
        btnSecond.setOnClickListener {
            setOnClickLickListener(")", true)
        }
        // clear
        btnAc.setOnClickListener {
            inputTextView.text = ""
            outputTextView.text = ""
        }
        btnBack.setOnClickListener {
            val text = inputTextView.text.toString()
            if (text.isNotEmpty()) {
                inputTextView.text = text.substring(0, text.length - 1)
            }
            outputTextView.text = ""
        }
        btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(inputTextView.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    outputTextView.text = longResult.toString()
                } else {
                    outputTextView.text = result.toString()
                }
            } catch (e:Exception) {
                Toast.makeText(this, "Massage: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setOnClickLickListener(inputText: String, clear: Boolean) {
        if (outputTextView.text.isNotEmpty()) {
            outputTextView.text = ""
        } else if (clear) {
            outputTextView.text = ""
            inputTextView.append(inputText)
        } else {
            inputTextView.append(outputTextView.text)
            inputTextView.append(inputText)
            outputTextView.text = ""
        }
    }

    private fun setFindView() {
        btnAc = binding.btnClear
        btnBack = binding.btnBack
        btn0 = binding.btn0
        btn1 = binding.btn1
        btn2 = binding.btn2
        btn3 = binding.btn3
        btn4 = binding.btn4
        btn5 = binding.btn5
        btn6 = binding.btn6
        btn7 = binding.btn7
        btn8 = binding.btn8
        btn9 = binding.btn9
        btnAdd = binding.btnAdd
        btnSub = binding.btnSub
        btnMul = binding.btnMul
        btnDiv = binding.btnDiv
        btnDot = binding.btnDot
        btnEqual = binding.btnEqual
        inputTextView = binding.inputTv
        outputTextView = binding.outputTv
        btnFirst = binding.btnFist
        btnSecond = binding.btnSecond
    }
}