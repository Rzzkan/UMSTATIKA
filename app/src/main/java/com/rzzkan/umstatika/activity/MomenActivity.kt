package com.rzzkan.umstatika.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.rzzkan.umstatika.databinding.ActivityMomenBinding
import com.rzzkan.umstatika.databinding.DialogCenteredBinding
import com.rzzkan.umstatika.databinding.DialogMomenBinding
import kotlinx.android.synthetic.main.dialog_centered.view.*
import java.text.DecimalFormat

class MomenActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMomenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMomenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
    }

    private fun clickListener(){
        binding.btnCalculate.setOnClickListener {
            if (binding.etRav.text.isEmpty()||
                binding.etJarak.text.isEmpty()
            ){
                Toast.makeText(this,"Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }else{
                calculate()
            }
        }

        binding.ibBack.setOnClickListener{
            finish()
        }
    }

    private fun calculate(){
        val rav = binding.etRav.text.toString()
        val x = binding.etJarak.text.toString()
        val df = DecimalFormat("#.##")

        var ma = 0
        var mx = +rav.toDouble() * x.toDouble()
        showDialogResult(df.format(ma).toString(), df.format(mx).toString())
    }

    private fun showDialogResult(m0:String, mx:String, ) {
        val dialog = Dialog(this)
        val bind : DialogMomenBinding = DialogMomenBinding.inflate(dialog.layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(bind.root)

        bind.tvM0.text = m0
        bind.tvMx.text = mx

        bind.ibClose.ibClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}