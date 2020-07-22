package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.IntentData
import com.example.test1.IntentParams
import com.example.test1.WebViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        open_pp_app.setOnClickListener {
//            var intent = packageManager.getLaunchIntentForPackage("com.prabhutech.prabhupay")
//            intent!!.putExtra("operatorCode", "28")
//            intent!!.putExtra("firstLabel", "subscriber")
//            intent!!.putExtra("firstValue", "ctdeveloper")
//            intent!!.putExtra("activity", "com.prabhutech.IntentFilter.IntentActivity")
//            startActivity(intent)
        }
    }
}