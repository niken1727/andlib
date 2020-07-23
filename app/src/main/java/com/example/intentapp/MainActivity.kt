package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.API.ApiServices
import com.example.intentapp.API.RestApi
import com.example.intentapp.API.RestApi1
import com.example.test1.IntentData
import com.example.test1.IntentParams
import com.example.test1.WebViewActivity
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppList();
        open_pp_app.setOnClickListener {
//            var intent = packageManager.getLaunchIntentForPackage("com.prabhutech.prabhupay")
//            intent!!.putExtra("operatorCode", "28")
//            intent!!.putExtra("firstLabel", "subscriber")
//            intent!!.putExtra("firstValue", "ctdeveloper")
//            intent!!.putExtra("activity", "com.prabhutech.IntentFilter.IntentActivity")
//            startActivity(intent)
            var intentParams = IntentParams(this)
            intentParams.intentData()
        }
    }

    private fun getAppList() {
        var compositeDisposable = CompositeDisposable()
        var jsonObject = JsonObject()
        var jsonArray = JsonArray()
        var a = JsonObject()
        a.addProperty("productName", "Cheese Cake")
        a.addProperty("quantity", "2")
        a.addProperty("rate", "449.7")
        a.addProperty("total", "899.4")
        jsonArray.add(a)

        jsonObject.addProperty("totalAmount", "899.4")
        jsonObject.addProperty("merchantId", "bajekosekuwa")
        jsonObject.addProperty("password", "Admin@123")
        jsonObject.addProperty("invoiceNo", "abc123")
        jsonObject.add("productDetails", jsonArray)
        jsonObject.addProperty("remarks", "test")
        jsonObject.addProperty("returnUrl", "https://google.com")
        RestApi.apiServices.initiate(jsonObject).subscribeOn(Schedulers.io()).safeSubscribe(object : DisposableObserver<JsonObject>() {
            override fun onComplete() {
            }

            override fun onNext(value: JsonObject?) {
                var a = value
            }

            override fun onError(e: Throwable?) {
                var a = e!!.message
            }

        })
    }
}

