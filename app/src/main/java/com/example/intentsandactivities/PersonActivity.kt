package com.example.intentsandactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity : AppCompatActivity() {

    lateinit var passedIntent:Intent
    var personellRecord : ArrayList<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        passedIntent = intent
    }

    fun onClick(view: View){

        when (view.id){
            R.id.btnSubmitPerson -> {
                val perFirstName = etFirstName.text.toString()
                val perLastName = etLastName.text.toString()
                val perAge = etAge.text.toString()
                val perGender = etGender.text.toString()
                val perHomeTown = etHomeTown.text.toString()
                val person = Person(perFirstName, perLastName, perAge,
                    perGender, perHomeTown)
                personellRecord.add(person)

                passedIntent.putExtra("PERSON", person)
                setResult(999, passedIntent)
            }
        }
    }
}
