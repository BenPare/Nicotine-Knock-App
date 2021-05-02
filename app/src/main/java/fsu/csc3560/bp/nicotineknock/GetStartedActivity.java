package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;


public class GetStartedActivity extends AppCompatActivity {

    int whatCount = 0;

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

                whatCount = 1;

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

                whatCount = 2;

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

                whatCount = 3;

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

                whatCount = 4;

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

        //what count should be incremented?
        switch (whatCount) {
            case 1 :
                //read
                int defCount = 0;
                int sCount = sharedPref.getInt(getString(R.string.stress_count), defCount);

                sCount++;

                //write
                editor.putInt(getString(R.string.stress_count), sCount);
                editor.apply();
            case 2 :
                //read
                defCount = 0;
                int sfCount = sharedPref.getInt(getString(R.string.social_factors_count), defCount);

                sfCount++;

                //write
                editor.putInt(getString(R.string.social_factors_count), sfCount);
                editor.apply();
            case 3 :
                //read
                defCount = 0;
                int bCount = sharedPref.getInt(getString(R.string.boredom_count), defCount);

                bCount++;

                //write
                editor.putInt(getString(R.string.boredom_count), bCount);
                editor.apply();
            case 4 :
                //read
                defCount = 0;
                int pCount = sharedPref.getInt(getString(R.string.pleasure_count), defCount);

                pCount++;

                //write
                editor.putInt(getString(R.string.pleasure_count), pCount);
                editor.apply();
            default :
                break;
        }

        //send the user back to the main activity after they make their choice
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}