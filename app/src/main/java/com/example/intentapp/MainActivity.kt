package com.example.intentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.IntentParams
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        open_pp_app.setOnClickListener {
            var arrayList = ArrayList<String>()
            arrayList.add("com.prabhutech.prabhupay")
            arrayList.add("28")
            arrayList.add("subscriber")
            arrayList.add("ctdeveloper")
            arrayList.add("com.prabhutech.IntentFilter.IntentActivity")
            var intentParams = IntentParams(applicationContext, arrayList)
            intentParams.intentData()
//            var intent = packageManager.getLaunchIntentForPackage("com.prabhutech.prabhupay")
//            intent!!.putExtra("operatorCode", "28")
//            intent!!.putExtra("firstLabel", "subscriber")
//            intent!!.putExtra("firstValue", "ctdeveloper")
//            intent!!.putExtra("activity", "com.prabhutech.IntentFilter.IntentActivity")
//            startActivity(intent)
        }
    }
}