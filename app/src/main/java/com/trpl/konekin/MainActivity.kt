package com.trpl.konekin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trpl.konekin.databinding.ActivityMainBinding
import com.trpl.konekin.model.*
import com.trpl.konekin.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val userList = ArrayList<String>()
        val dataList = ArrayList<String>()
        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                for( i in response.body()?.data!!) {
                    userList.add(i.nameApi)
                    dataList.add(i.speciesType)
                    dataList.add(i.speciesGender)
                    dataList.add(i.statusApi)
                    dataList.add(i.speciesImage)
                    val listAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, userList)
                    binding.lvNama.adapter = listAdapter
                }
            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
        with(binding) {
            lvNama.setOnItemClickListener { _, _, arg2, _ ->
                val intenttoDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)
                intenttoDetailActivity.putExtra("name", dataList[arg2])
                intenttoDetailActivity.putExtra("type", dataList[arg2])
                intenttoDetailActivity.putExtra("status", dataList[arg2*2])
                intenttoDetailActivity.putExtra("image", dataList[arg2*3])
                startActivity(intenttoDetailActivity)
            }
        }
    }
}