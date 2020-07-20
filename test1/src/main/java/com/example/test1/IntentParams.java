package com.example.test1;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Niken on 7/20/2020.
 */
public class IntentParams {
    private Context context;
    ArrayList<String> arrayList;

    public IntentParams(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void intentData(){
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(arrayList.get(0));
        intent.putExtra("operatorCode", arrayList.get(1));
        intent.putExtra("firstLabel", arrayList.get(2));
        intent.putExtra("firstValue", arrayList.get(3));
        intent.putExtra("activity", arrayList.get(4));
        context.startActivity(intent);
    }
}
