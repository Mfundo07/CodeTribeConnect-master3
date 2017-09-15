package com.example.android.codetribeconnect;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by RP on 2017/09/02.
 */

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().getReference().child("verified_user_profile").keepSynced(true);
    }
}
