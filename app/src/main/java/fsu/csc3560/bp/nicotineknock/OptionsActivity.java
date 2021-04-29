package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class OptionsActivity extends AppCompatActivity
        implements setCostBox.NoticeDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void setCostButton(View view) {
        FragmentManager costFrag;
        costFrag = getSupportFragmentManager();
        FragmentTransaction ft = costFrag.beginTransaction();
        ft.commit();
        setCostBox newBox = new setCostBox();
        newBox.show(costFrag, "Inspirational Quote Dialog Fragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

}