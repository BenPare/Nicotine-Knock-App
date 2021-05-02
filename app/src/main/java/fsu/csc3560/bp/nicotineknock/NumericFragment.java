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
        custom.setText(getString(R.string.text_not_smoked));
        TextView customNot = (TextView) returnView.findViewById(R.id.notSmoked);
        customNot.setText(""+ noCount);

        int countStress = sharedPref.getInt(getString(R.string.stress_count), defCount);
        int countSocial = sharedPref.getInt(getString(R.string.social_factors_count), defCount);
        int countBoredom = sharedPref.getInt(getString(R.string.boredom_count), defCount);
        int countPleasure = sharedPref.getInt(getString(R.string.pleasure_count), defCount);

        TextView textReason = (TextView) returnView.findViewById(R.id.textReason);

        if ((countStress >= countSocial) && (countStress >= countBoredom) && (countStress >= countPleasure)) {
            //Largest is countStress
            textReason.setText(R.string.stress_reason);
        }
        else if ((countSocial >= countBoredom) && (countSocial >= countPleasure)) {
            //Largest is countSocial
            textReason.setText(R.string.social_factors_reason);
        }
        else if ((countBoredom >= countPleasure)) {
            //Largest is countBoredom
            textReason.setText(R.string.boredom_reason);
        }
        else {
            //Largest is countPleasure
            textReason.setText(R.string.pleasure_reason);
        }

        return returnView;
    }

}
