package fsu.csc3560.bp.nicotineknock;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class MoneyFragment extends Fragment {
    String data = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View returnView = inflater.inflate(R.layout.moneyfragment, container, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        double defDouble = 6.65;
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

        String currency = sharedPref.getString(getString(R.string.saved_currency), "Dollars");

        TextView custom = (TextView) returnView.findViewById(R.id.customMoneyText);
        custom.setText("Money saved based on your brand cost ($" + price + ") of cigarettes:");
        TextView custom2 = (TextView) returnView.findViewById(R.id.savedMoney);
        custom2.setText("$"+ rounded + " (" + currency+ ")");

        double defSaved = (defDouble/20)*noCount;
        BigDecimal bDef = new BigDecimal(defSaved);
        bDef = bDef.round(new MathContext(3));
        double roundDef = bDef.doubleValue();

        TextView defaultText = (TextView) returnView.findViewById(R.id.defaultMoneyText);
        defaultText.setText("Money saved based on the average cost ($" + defDouble +  ") of any box of cigarettes: ");
        TextView defaultText2 = (TextView) returnView.findViewById(R.id.savedDefault);
        defaultText2.setText("$" + roundDef + " (" + currency +")");
        return returnView;
    }}
