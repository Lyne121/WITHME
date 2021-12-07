package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class mainLodingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_loding)

        val myhandler = Handler(Looper.getMainLooper() )

        myhandler.postDelayed( {

                               val myIntent = Intent(this, MainLoginActivity::class.java)
            startActivity(myIntent)

            finish()

        } , 2000 )


    }

}