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
        val genderData = dataIntent.getStringExtra("gender")
        val imgUrl = dataIntent.getStringExtra("status")
        val imageData = dataIntent.getStringExtra("image")

        with(binding){
            Glide.with(this@DetailActivity).load(imageData).into(imageBahasa)
            val detailTitle = "$titleData"
            textView.text = detailTitle
            val titleShown = "Name: $titleData"
            tvJudul.text = titleShown
            val gender = "Gender: $genderData"
            tvGender.text = gender
            val descshown = "Type Species: $typeData"
            tvDesc.text = descshown
            val yearshown = "Status: $imgUrl"
            tvTahun.text = yearshown
        }
    }
}