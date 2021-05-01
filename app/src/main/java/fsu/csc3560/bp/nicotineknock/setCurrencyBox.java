package fsu.csc3560.bp.nicotineknock;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class setCurrencyBox extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.currencyalert, null);
        final EditText etName = (EditText) v.findViewById(R.id.EditTextCurrency);
        builder.setView(v)
                .setPositiveButton("Set Currency", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String newString = etName.getText().toString();

                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.saved_currency), newString);
                        editor.apply();

                        String currency = sharedPref.getString(getString(R.string.saved_currency), "Dollars");
                        TextView currencyView = (TextView) getActivity().findViewById(R.id.textViewCurrency);
                        currencyView.setText(getString(R.string.current_currency) + currency);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}
