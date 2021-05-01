package fsu.csc3560.bp.nicotineknock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void optionsButton(MenuItem item) {

        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);

    }

    public void websiteButton(MenuItem item) {

        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.cdc.gov/tobacco/quit_smoking/index.htm"));
        startActivity(viewIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager signFrag;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                //to the settings activity
                return true;
            case R.id.quit:
                //prompt to close the app
                signFrag = getSupportFragmentManager();
                FragmentTransaction ft = signFrag.beginTransaction();
                ft.commit();
                signOut quit = new signOut();
                quit.show(signFrag, "shuts down the app");
                return true;
            case R.id.about:
                //to the CDC website
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void shareIntent(MenuItem item) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        int defCount = 0;
        String defValue = "6.65";
        String price = sharedPref.getString(getString(R.string.saved_pack_cost), defValue);
        int noCount = sharedPref.getInt(getString(R.string.negative_count), defCount);
        //I'm sure this math can be optimized somehow
        double one = Double.parseDouble(price)/20;
        double saved = one*noCount;
        BigDecimal bd = new BigDecimal(saved);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();

        long timeZero = 0;
        long lastTime = sharedPref.getLong(getString(R.string.smoke_time), timeZero);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(lastTime);

        String txt = "I have saved " + rounded + " by not smoking cigarettes and I have not had a cigarette since " + formatter.format(date) + "!";
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("use a different app")
                .setText(txt)
                .startChooser();
    }

    public void updateToast(MenuItem item) {

        Toast.makeText(MainActivity.this, "It has been X days since your last cigarette!", Toast.LENGTH_LONG).show();

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