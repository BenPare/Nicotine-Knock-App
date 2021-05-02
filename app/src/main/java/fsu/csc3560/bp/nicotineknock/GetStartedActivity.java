package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Button oneButton = (Button) findViewById(R.id.radioButton1);
        oneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(GetStartedActivity.this);
                builder.setMessage("Stress is a normal part of life—in moderation it can help you reach" +
                        " your goals, but too much stress creates more problems. Managing stress is" +
                        " a key part to quitting smoking.");
                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button twoButton = (Button) findViewById(R.id.radioButton2);
        twoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(GetStartedActivity.this);
                builder.setMessage("The key is realising that you don’t need to smoke to enjoy your " +
                        "evening out or time with friends!");
                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        Button threeButton = (Button) findViewById(R.id.radioButton3);
        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(GetStartedActivity.this);
                builder.setMessage("Boredom is an emotional trigger, which means that when you get " +
                        "that bored feeling, your brain immediately craves a cigarette. Finding a " +
                        "new distraction can help avoid those cravings!");
                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        Button fourButton = (Button) findViewById(R.id.radioButton4);
        fourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(GetStartedActivity.this);
                builder.setMessage("One reason people smoke is that the nicotine helps them relax " +
                        "and provides pleasure.There are many options. " +
                        "You can exercise to blow off steam, tune in to your favorite music, " +
                        "connect with friends, treat yourself to a massage, or make time for a hobby.");
                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

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

        //send the user back to the main activity after they make their choice
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void didButton(View view) {
        //smoke button
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        long smokeTime = System.currentTimeMillis();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(getString(R.string.smoke_time), smokeTime);
        editor.apply();

        //send the user back to the main activity after they make their choice
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void inspoAlert(MenuItem item) {

        FragmentManager inspoFrag;
        inspoFrag = getSupportFragmentManager();
        FragmentTransaction ft = inspoFrag.beginTransaction();
        ft.commit();
        inspirationalQuote quoteAlert = new inspirationalQuote();
        quoteAlert.show(inspoFrag, "Inspirational Quote Dialog Fragment");

    }

}