package com.trpl.konekin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.trpl.konekin.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent
        val titleData = dataIntent.getStringExtra("name")
        val typeData = dataIntent.getStringExtra("type")
        val imgUrl = dataIntent.getStringExtra("status")
        val imageData = dataIntent.getStringExtra("image")

        with(binding){
            Glide.with(this@DetailActivity).load(imageData).into(imageBahasa)
            val detailTitle = "Detail Species $titleData"
            textView.text = detailTitle
            val titleShown = "Nama Species: $titleData"
            tvJudul.text = titleShown
            val descshown = "Type Species: $typeData"
            tvDesc.text = descshown
            val yearshown = "Status: $imgUrl"
            tvTahun.text = yearshown
        }
    }
}