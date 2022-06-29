package com.rzzkan.umstatika.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.databinding.ActivityEquallyBinding
import com.rzzkan.umstatika.databinding.DialogCenteredBinding
import com.rzzkan.umstatika.databinding.DialogEquallyBinding
import kotlinx.android.synthetic.main.dialog_centered.view.*
import java.text.DecimalFormat
import kotlin.math.absoluteValue

class EquallyActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEquallyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEquallyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
    }

    private fun clickListener(){
        binding.ibBack.setOnClickListener{
            finish()
        }

        binding.ibTheory.setOnClickListener{
            val intent = Intent(this@EquallyActivity, TheoryActivity::class.java)
            intent.putExtra("title", "2. beban merata")
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

    private fun calculate(){
        val q = binding.etBeban.text.toString()
        val l = binding.etPanjang.text.toString()
        val x = binding.etJarak.text.toString()
        val df = DecimalFormat("#.##")

        var rav = (q.toDouble()/2)*l.toDouble()
        var rbv = rav
        var dab = rav
        var dba = (-rbv)

        var mx = (rav * x.toDouble()) - (q.toDouble()/2 * (x.toDouble()*x.toDouble()))
        var mmax = (q.toDouble()/8)*(l.toDouble() * l.toDouble())

//            showDialogResult(rav.toString(), rbv.toString(), dab.absoluteValue.toString(), dba.toString(), mx.toString(), mmax.absoluteValue.toString() )
            showDialogResult(df.format(rav).toString(), df.format(rbv).toString(), df.format(dab.absoluteValue).toString(), df.format(dba).toString(),df.format(mx).toString(), df.format(mmax.absoluteValue).toString() )
    }

    private fun showDialogResult(rav:String, rbv:String, dab:String, dba:String, mx:String, mmax:String) {
        val dialog = Dialog(this)
        val bind : DialogEquallyBinding = DialogEquallyBinding.inflate(dialog.layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(bind.root)

        bind.tvRav.text = rav
        bind.tvRbv.text = rbv
        bind.tvDab.text = dab
        bind.tvDba.text = dba
        bind.tvMx.text =  mx
        bind.tvMmaks.text = mmax


        bind.ibClose.ibClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

}