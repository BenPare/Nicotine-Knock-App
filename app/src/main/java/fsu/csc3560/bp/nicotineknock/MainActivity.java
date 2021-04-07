package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startButton(View view) {
        Intent intent = new Intent(this, GetStartedActivity.class);
        startActivity(intent);
    }

    public void analyticsButton(View view) {
        Intent intent = new Intent(this, AnalyticsActivity.class);
        startActivity(intent);
    }

    public void optionsButton(View view) {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void websiteButton(View view) {
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.cdc.gov/tobacco/quit_smoking/index.htm"));
        startActivity(viewIntent);
    }
}