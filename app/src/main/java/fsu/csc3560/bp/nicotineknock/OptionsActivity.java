package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        String price = sharedPref.getString(getString(R.string.saved_pack_cost), "6.65");
        TextView costView = (TextView) findViewById(R.id.textViewCost);
        costView.setText(getString(R.string.current_cost) + price);

        String currency = sharedPref.getString(getString(R.string.saved_currency), "Dollars");
        TextView currencyView = (TextView) findViewById(R.id.textViewCurrency);
        currencyView.setText(getString(R.string.current_currency) + currency);
    }

    public void setCostButton(View view) {
        FragmentManager costFrag;
        costFrag = getSupportFragmentManager();
        FragmentTransaction ft = costFrag.beginTransaction();
        ft.commit();
        setCostBox newBox = new setCostBox();
        newBox.show(costFrag, "Cost dialog fragment");
    }

    public void setCurrencyButton(View view) {
        FragmentManager currencyFrag;
        currencyFrag = getSupportFragmentManager();
        FragmentTransaction ft = currencyFrag.beginTransaction();
        ft.commit();
        setCurrencyBox newBox = new setCurrencyBox();
        newBox.show(currencyFrag, "Currency dialog fragment");
    }

}