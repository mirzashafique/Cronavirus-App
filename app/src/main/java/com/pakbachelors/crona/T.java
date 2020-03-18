package com.pakbachelors.crona;

import android.content.Context;
import android.widget.Toast;

public class T {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
