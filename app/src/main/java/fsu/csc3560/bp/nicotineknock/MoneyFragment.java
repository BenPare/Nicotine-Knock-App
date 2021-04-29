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
import java.util.Scanner;

public class MoneyFragment extends Fragment {
    String data = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View returnView = inflater.inflate(R.layout.moneyfragment, container, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        int defValue = 665;
        int price = sharedPref.getInt(getString(R.string.saved_pack_cost), defValue);

        TextView custom = (TextView) returnView.findViewById(R.id.customMoneyText);
        custom.setText("Money saved based on your brand cost of " + Integer.toString(price));
        return returnView;
    }}
