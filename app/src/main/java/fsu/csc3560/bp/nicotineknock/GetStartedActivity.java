package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }

    public void notButton(View view) {
        /*increment count*/

        //read
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int defCount = 1;
        int noCount = sharedPref.getInt(getString(R.string.negative_count), defCount);

        noCount++;

        //write
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.negative_count), noCount);
        editor.apply();
    }

    public void didButton(View view) {
        //smoke button
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        long smokeTime = System.currentTimeMillis();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(getString(R.string.smoke_time), smokeTime);
        editor.apply();
    }
}