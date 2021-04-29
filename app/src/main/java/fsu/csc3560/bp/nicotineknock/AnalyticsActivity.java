package fsu.csc3560.bp.nicotineknock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalyticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        Button moneyBtn = findViewById(R.id.moneyButton);
        moneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of your Fragment
                MoneyFragment computer = new MoneyFragment();
                // Create an instance of FragmentManager
                FragmentManager frag = getSupportFragmentManager();
                // Begin the transaction
                FragmentTransaction ft = frag.beginTransaction();
                // add new fragment in the container, can use replace
                ft.replace(R.id.fragment_placeholder,computer);
                // commit the transaction
                ft.commit();
            }
        });

        Button numberBtn = findViewById(R.id.numberButton);
        numberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of your Fragment
                NumericFragment numbers = new NumericFragment();
                // Create an instance of FragmentManager
                FragmentManager frag = getSupportFragmentManager();
                // Begin the transaction
                FragmentTransaction ft = frag.beginTransaction();
                // add new fragment in the container, can use replace
                ft.replace(R.id.fragment_placeholder,numbers);
                // commit the transaction
                ft.commit();
            }
        });

        Button timeBtn = findViewById(R.id.timeButton);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of your Fragment
                TimeFragment numbers = new TimeFragment();
                // Create an instance of FragmentManager
                FragmentManager frag = getSupportFragmentManager();
                // Begin the transaction
                FragmentTransaction ft = frag.beginTransaction();
                // add new fragment in the container, can use replace
                ft.replace(R.id.fragment_placeholder,numbers);
                // commit the transaction
                ft.commit();
            }
        });

    }
}