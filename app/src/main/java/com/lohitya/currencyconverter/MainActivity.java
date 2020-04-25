package com.lohitya.currencyconverter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.DeflaterOutputStream;

public class MainActivity extends AppCompatActivity {

    public void btn2INR(View view) {
        try {
            EditText usdAmt = findViewById(R.id.usd2inr_in);
            String usdAmt_str = usdAmt.getText().toString();
            Double usdAmt_dec = Double.parseDouble(usdAmt_str);
            Double inrAmt_dec = usdAmt_dec * 70;
            String toastText = String.format("Amount in INR = Rs.%.2f", inrAmt_dec);
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            String toastText = "Input is Empty";
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        }
    }

    public void btn2USD(View view) {
        try {
            EditText inrAmt = findViewById(R.id.inr2usd_in);
            String inrAmt_str = inrAmt.getText().toString();
            Double inrAmt_dec = Double.parseDouble(inrAmt_str);
            Double usdAmt_dec = 0.0;
            if (inrAmt_dec != 0)
                usdAmt_dec = inrAmt_dec / 70;
            else
                usdAmt_dec = 0.0;
            String toastText = String.format("Amount in USD = $%.2f", usdAmt_dec);
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            String toastText = "Input is Empty";
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
