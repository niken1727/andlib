package com.example.test1;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Niken on 7/20/2020.
 */
public class IntentParams {
    private Context context;

    public IntentParams(Context context) {
        this.context = context;
    }

    public void intentData(){
        Intent intent = new Intent(context, WebViewActivity.class);
        context.startActivity(intent);
    }

}
