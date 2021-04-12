package fsu.csc3560.bp.nicotineknock;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Random;

public class inspirationalQuote extends DialogFragment {

    //this class makes use of static integers.  If you add to the array that holds inspirational strings then
    //you have to change the static integers that interact with the inspirational quotes array of strings.

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String[] inspoQuotes = getResources().getStringArray(R.array.inspirational_quotes);
        String[] arrQuotes = new String[inspoQuotes.length];
        String[] arrNames = new String[inspoQuotes.length];
        for (int i = 0; i < inspoQuotes.length - 1; i++) {
            //split the string, the names are on the end after an underscore
            String[] parts = inspoQuotes[i].split("_");
            String quote = parts[0]; // quote
            String name = parts[1]; // quoted by

            arrQuotes[i] = quote;
            arrNames[i] = name;
        }

        Random rand = new Random();
        int upperbound = inspoQuotes.length - 1; //upperbound takes the number of inspirational quotes
        int here = rand.nextInt(upperbound);

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(arrNames[here])
                .setMessage(arrQuotes[here])
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User affirms the dialog
                    }
                })
                //I've looked into a negative button that will generate a new quote but I couldn't get it to work
                //the easiest way to do this would be using something other than an alert box.
                ;
        // Create the AlertDialog object and return it
        return builder.create();
    }
}