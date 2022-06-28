package com.rzzkan.umstatika.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rzzkan.dicoding.adapter.MenuAdapterHorizontal
import com.rzzkan.dicoding.adapter.MenuAdapterVertical
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.databinding.ActivityMainBinding
import com.rzzkan.umstatika.model.Menu
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.EasyPermissions

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var topList = ArrayList<Menu>()
    private var bottomList = ArrayList<Menu>()
    lateinit var topAdapter:MenuAdapterHorizontal
    lateinit var bottomAdapter:MenuAdapterVertical

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialization()
        addData()
        clickListener()
    }

    private fun initialization(){
        binding.rvCategory.setHasFixedSize(true)
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        topAdapter = MenuAdapterHorizontal(topList)
        rvCategory.adapter = topAdapter

        binding.rvTheory.setHasFixedSize(true)
        rvTheory.layoutManager = LinearLayoutManager(this)
        bottomAdapter = MenuAdapterVertical(bottomList)
        rvTheory.adapter = bottomAdapter
    }

    private fun addData(){
        topList.add(Menu(R.drawable.ic_group_terpusat,"Beban Terpusat",""))
        topList.add(Menu(R.drawable.ic_merata,"Beban Merata",""))
        topList.add(Menu(R.drawable.ic_segitiga,"Beban Segitiga",""))
        topAdapter.notifyDataSetChanged()

        bottomList.add(Menu(R.drawable.terpusat, "1. Beban Terpusat", "Balok Diatas Dua Perletakan Memikul Sebuah Muatan Terpusat"))
        bottomList.add(Menu(R.drawable.merata, "2. Beban Merata", "Balok Diatas Dua Perletakan Memikul Muatan Terbagi Rata"))
        bottomList.add(Menu(R.drawable.segitiga, "3. Beban Segitiga", "Balok Diatas Dua Perletakan Memikul Muatan Segi Tiga"))
        bottomAdapter.notifyDataSetChanged()
    }

    private fun clickListener(){
        topAdapter.setOnItemClickCallback(
            object : MenuAdapterHorizontal.OnItemClickCallback{
                override fun onItemClicked(data: Menu) {
                    if (data.title.equals("beban terpusat",true)){
                        val intent = Intent(this@MainActivity,CenteredActivity::class.java)
                        startActivity(intent)
                    }
                    else if (data.title.equals("beban merata",true)){
                        val intent = Intent(this@MainActivity,EquallyActivity::class.java)
                        startActivity(intent)
                    }
                    else if (data.title.equals("beban segitiga",true)){
                        val intent = Intent(this@MainActivity,TriangleActivity::class.java)
                        startActivity(intent)
                    }

                }

            }
        )

        bottomAdapter.setOnItemClickCallback(
            object : MenuAdapterVertical.OnItemClickCallback{
                override fun onItemClicked(data: Menu) {
                    val intent = Intent(this@MainActivity, TheoryActivity::class.java)
                    intent.putExtra("title", data.title)
                    startActivity(intent)
                }

            }
        )

        binding.ibAbout.setOnClickListener{
            val intent = Intent(this@MainActivity,AboutActivity::class.java)
            startActivity(intent)
        }

        binding.btnExit.setOnClickListener{
            finish()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}