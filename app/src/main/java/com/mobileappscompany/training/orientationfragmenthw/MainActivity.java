package com.mobileappscompany.training.orientationfragmenthw;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OneFragment.MoveToFrag2 {
    private static final String LOG_TAG = "HOMEWORK_TAG";
    OneFragment frag1;
    TwoFragment frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frag1 = new OneFragment();
        frag2 = new TwoFragment();

        onOrientationChange();
        Log.d(LOG_TAG, "onCreate is called");

    }

    public void onOrientationChange() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            FragmentManager manager = getSupportFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.add(R.id.frame_layout_activity, frag1);
            transaction.commit();

        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            FragmentManager manager3 = getSupportFragmentManager();

            FragmentTransaction transaction3 = manager3.beginTransaction();
            transaction3.add(R.id.frameLayout1, frag1);
            transaction3.add(R.id.frameLayout2, frag2);
            transaction3.commit();
        }
    }


    @Override
    public void goToFrag2() {

        FragmentManager manager2 = getSupportFragmentManager();

        FragmentTransaction transaction2 = manager2.beginTransaction();

        transaction2.replace(R.id.frame_layout_activity, frag2);
        transaction2.addToBackStack(null);

        transaction2.commit();

        onStart();


    }

    @Override
    public void goToFrag1() {
        FragmentManager manager5 = getSupportFragmentManager();

        FragmentTransaction transaction5 = manager5.beginTransaction();

        transaction5.replace(R.id.frame_layout_activity, frag1);
        transaction5.addToBackStack(null);

        transaction5.commit();

        onStart();
    }

    @Override
    public void setTextFrag2(String s) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(LOG_TAG, "goToFrag2 is called");
            frag2.textView2.setText(s);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (frag1.btn.isEnabled()) {
                frag2.textView2.setText(s);
            }
        }
    }

    @Override
    public void setTextFrag1(String s) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(LOG_TAG, "goToFrag2 is called");
            frag1.textView1.setText(s);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (frag2.btn2.isEnabled()) {
                frag1.textView1.setText(s);
            }
        }
    }
}
