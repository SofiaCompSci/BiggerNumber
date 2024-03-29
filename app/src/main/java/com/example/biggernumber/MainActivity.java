package com.example.biggernumber;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
    public boolean buttonManager(boolean b){
        TextView button1 = this.findViewById(R.id.button1);
        TextView button2 = this.findViewById(R.id.button2);
        int b1read = Integer.parseInt(button1.getText().toString());
        int b2read = Integer.parseInt(button2.getText().toString());
        if (b) {
            return b1read > b2read;
        }
        else{
            Random r = new Random();
            Random s = new Random();
            String number1 = Integer.toString(r.nextInt(10)-5);
            String number2 = Integer.toString(s.nextInt(10)-5);
            button1.setText(number1);
            button2.setText(number2);
            return true;
        }
    }
    @SuppressLint("SetTextI18n")
    public void on_b1_click(View view){
        TextView ans = this.findViewById(R.id.Answer);
        TextView points = this.findViewById(R.id.pointsNum);
        int pValue = Integer.parseInt(points.getText().toString());
        boolean B1IsBigger = buttonManager(true);
        if (B1IsBigger){
            ans.setText("Congratulations!");
            pValue ++;
            points.setText(Integer.toString(pValue));
        }
        else{
            ans.setText("Incorrect");
        }
        buttonManager(false);
    }
    @SuppressLint("SetTextI18n")
    public void on_b2_click(View view){
        TextView ans = this.findViewById(R.id.Answer);
        TextView points = this.findViewById(R.id.pointsNum);
        int pValue = Integer.parseInt(points.getText().toString());
        boolean B1IsBigger = buttonManager(true);
        if (!B1IsBigger){
            ans.setText("Congratulations!");
            pValue ++;
            points.setText(Integer.toString(pValue));
        }
        else{
            ans.setText("Incorrect");
        }
        buttonManager(false);
    }
}
