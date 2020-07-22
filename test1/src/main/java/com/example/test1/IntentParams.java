package com.example.test1;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Niken on 7/20/2020.
 */
public class IntentParams {
    private Context context;
    ArrayList<IntentData> arrayList;

    public IntentParams(Context context, ArrayList<IntentData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void intentData(){
        Intent intent = new Intent(context, arrayList.get(0).intentClass);
        intent.putExtra("url", arrayList.get(0).url);
        context.startActivity(intent);
    }

}
