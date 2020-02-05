package com.example.intentsandactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_person_result.*

class PersonResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_result)

        var personRecords = intent.getParcelableArrayListExtra<Person>("personellRecord")
        tvPersonell.text = personRecords.toString()
    }
}
