package com.example.intentsandactivities

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

const val TAG_MAIN_ACTIVITY = "TAG_MAIN"
const val TAG_DISPLAY_ACTIVITY = "TAG_DISPLAY"

class MainActivity : AppCompatActivity() {

    var personList : ArrayList<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnCameraCapture -> {
                intent = Intent(this, PhotoActivity::class.java)
                startActivity(intent)
            }
            R.id.btnEMICalc -> {
                intent = Intent(this, EMIActivity::class.java)
                startActivity(intent)
            }
            R.id.btnNewPerson -> {
                intent = Intent(this, PersonActivity::class.java)
                startActivityForResult(intent, 999)
            }
            R.id.btnViewPersonell -> {
                intent = Intent(this, PersonResultActivity::class.java)
                intent.putParcelableArrayListExtra("personellRecord",personList)
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 999 && resultCode == 999){
            personList.add(data?.getParcelableExtra<Person>("PERSON") as Person)

        }
        Log.d(TAG_DISPLAY_ACTIVITY,data?.getParcelableArrayExtra("PERSON").toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
    }
}
