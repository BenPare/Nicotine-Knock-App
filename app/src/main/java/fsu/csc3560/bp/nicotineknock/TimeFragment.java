package fsu.csc3560.bp.nicotineknock;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View returnView = inflater.inflate(R.layout.timefragment, container, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        long timeZero = 0;
        long lastTime = sharedPref.getLong(getString(R.string.smoke_time), timeZero);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(lastTime);
        Date now = new Date(System.currentTimeMillis());

        TextView stText = (TextView) returnView.findViewById(R.id.smokeTimeText);
        stText.setText("The day you had your last cigarette: " + formatter.format(date));

        TextView dnText = (TextView) returnView.findViewById(R.id.textDayNumber);
        dnText.setText("Number of days since last cigarette: " + MainActivity.getDayCount(formatter.format(date), formatter.format(now)));

        return returnView;
    }}
