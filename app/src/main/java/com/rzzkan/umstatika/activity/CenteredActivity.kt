package com.rzzkan.umstatika.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.databinding.ActivityCenteredBinding
import com.rzzkan.umstatika.databinding.DialogCenteredBinding
import kotlinx.android.synthetic.main.activity_centered.*
import kotlinx.android.synthetic.main.dialog_centered.view.*
import java.text.DecimalFormat

class CenteredActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCenteredBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCenteredBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
    }
    private fun clickListener(){
        binding.ibBack.setOnClickListener{
            finish()
        }

        binding.ibTheory.setOnClickListener{
            val intent = Intent(this@CenteredActivity, TheoryActivity::class.java)
            intent.putExtra("title", "1. beban terpusat")
            startActivity(intent)
        }

        binding.btnCalculate.setOnClickListener {
            if (binding.etBeban.text.isEmpty()||
                binding.etPanjang.text.isEmpty()||
                binding.etJarak.text.isEmpty()
            ){
                Toast.makeText(this,"Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }else{
                calculate()
            }
        }
    }

    private fun showDialogResult(rav:String, rbv:String, dac:String, dca:String, dcb:String, dbc:String) {
        val dialog = Dialog(this)
        val bind :DialogCenteredBinding = DialogCenteredBinding.inflate(dialog.layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(bind.root)

        bind.tvRav.text = rav
        bind.tvRbv.text = rbv
        bind.tvDac.text = dac
        bind.tvDca.text = dca
        bind.tvDcb.text = dcb
        bind.tvDbc.text = dbc

        bind.btnMomen.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this@CenteredActivity, MomenActivity::class.java)
            startActivity(intent)
        }

        bind.ibClose.ibClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun calculate(){
        val p= etBeban.text.toString()
        val c= etJarak.text.toString()
        val l= etPanjang.text.toString()
        var rav = 0.0
        var rbv = 0.0
        var dac = 0.0
        var dca = 0.0
        var dcb = 0.0
        var dbc = 0.0
        val df = DecimalFormat("#.##")

        rav = p.toDouble() * c.toDouble()/l.toDouble()
        rbv = p.toDouble() * c.toDouble()/l.toDouble()

        dac = rav
        dca = dac
        dcb = dca - p.toDouble()
        dbc = -rbv

//        showDialogResult(rav.toString(), rbv.toString(), dca.toString(), dca.toString(), dcb.toString(), dbc.toString() )
        showDialogResult(df.format(rav).toString(),df.format(rbv).toString(),df.format(dca).toString(),df.format(dca).toString(), df.format(dcb).toString(), df.format(dbc).toString() )
    }

}