package com.example.intentsandactivities

import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rating.*

class Rating : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
    }

    fun onClick(view: View) {
        val ratingbar = findViewById<RatingBar>(R.id.ratingBar)
        val starsRated = ratingbar.rating.toString()
        when (view.id) {
            R.id.btnRating -> {
                tvRating.text = "Thanks for the " + starsRated + " Star rating!"
            }
        }
    }
}
