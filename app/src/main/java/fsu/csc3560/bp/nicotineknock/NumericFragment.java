package fsu.csc3560.bp.nicotineknock;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;

public class NumericFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View returnView = inflater.inflate(R.layout.numericfragment, container, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        int defCount = 0;
        int noCount = sharedPref.getInt(getString(R.string.negative_count), defCount);
        //I'm sure this math can be optimized somehow

        TextView custom = (TextView) returnView.findViewById(R.id.smokeTimeText);
        custom.setText("Number of cigarettes not smoked: " + noCount);

        return returnView;
    }

}
