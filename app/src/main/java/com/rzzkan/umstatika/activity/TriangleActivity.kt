package com.rzzkan.umstatika.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.databinding.ActivityTriangleBinding
import com.rzzkan.umstatika.databinding.DialogEquallyBinding
import com.rzzkan.umstatika.databinding.DialogTriangleBinding
import kotlinx.android.synthetic.main.activity_centered.*
import kotlinx.android.synthetic.main.dialog_centered.view.*
import java.text.DecimalFormat

class TriangleActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTriangleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriangleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
    }

    private fun clickListener(){
        binding.ibBack.setOnClickListener{
            finish()
        }

        binding.ibTheory.setOnClickListener{
            val intent = Intent(this@TriangleActivity, TheoryActivity::class.java)
            intent.putExtra("title", "3. beban segitiga")
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
        val q= etBeban.text.toString()
        val x= etJarak.text.toString()
        val l= etPanjang.text.toString()
        var rav = 0.0
        var rbv = 0.0
        var dab = 0.0
        var dba = 0.0
        var qx = 0.0
        var mx = 0.0
        var mmax = 0.0
        val df = DecimalFormat("#.##")

        rav = (q.toDouble()/6)*l.toDouble()
        rbv = (q.toDouble()/3)*l.toDouble()

        dab = rav
        dba = -rbv

        qx = (q.toDouble()/2)*((x.toDouble()*x.toDouble())/l.toDouble())
        mx = (q.toDouble()*l.toDouble()*x.toDouble()/6) - (q.toDouble()/6)*((x.toDouble()*x.toDouble()*x.toDouble())/l.toDouble())
        mmax = (1/27)*(q.toDouble())*(l.toDouble()*l.toDouble())*Math.cbrt(3.0)

//        showDialogResult(rav.toString(), rbv.toString(), dab.toString(), dba.toString(), qx.toString(), mx.toString(), mmax.toString())
        showDialogResult(df.format(rav).toString(), df.format(rbv).toString(), df.format(dab).toString(), df.format(dba).toString(), df.format(qx).toString(), df.format(mx).toString(), df.format(mmax).toString())
    }

    private fun showDialogResult(rav:String, rbv:String, dab:String, dba:String,qx:String, mx:String, mmax:String) {
        val dialog = Dialog(this)
        val bind : DialogTriangleBinding = DialogTriangleBinding.inflate(dialog.layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(bind.root)

        bind.tvRav.text = rav
        bind.tvRbv.text = rbv
        bind.tvDab.text = dab
        bind.tvDba.text = dba
        bind.tvQx.text =  qx
        bind.tvMx.text =  mx
        bind.tvMmax.text = mmax


        bind.ibClose.ibClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

}