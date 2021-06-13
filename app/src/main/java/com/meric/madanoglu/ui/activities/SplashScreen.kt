package com.meric.madanoglu.ui.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.meric.madanoglu.R

class SplashScreen : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initializeVariables()
        startTimer()
    }

    private fun initializeVariables(){
        imageView = findViewById(R.id.imageView)
    }

    private fun startTimer(){

        var i = -1

        object : CountDownTimer(4500,900){
            override fun onTick(millisUntilFinished: Long) {
                i++

                if (i == 1)
                    imageView.visibility = View.VISIBLE
                else if (i == 4)
                    imageView.visibility = View.INVISIBLE
            }

            override fun onFinish() {
                if (checkInternetConnection() != null && checkInternetConnection()!!){
                    val intent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this@SplashScreen, getString(R.string.nointernet), Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

        }.start()

    }

    private fun checkInternetConnection() : Boolean?{
        val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo

        return networkInfo?.isConnected
    }
}