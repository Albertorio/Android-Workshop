package com.chamas.luis.workshop_demo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText temp;
    private RadioButton cel, far;
    private Button go;
    private String tempStr;
    private double tempNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        temp = (EditText)findViewById(R.id.editText);
        cel = (RadioButton)findViewById(R.id.radioButton2);
        far = (RadioButton)findViewById(R.id.radioButtonFare);
        go = (Button)findViewById(R.id.button);

    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.radioButton2:
                if(checked){
                    cel.setChecked(true);
                    far.setChecked(false);
                }
                break;
            case R.id.radioButtonFare:
                if(checked){
                    cel.setChecked(false);
                    far.setChecked(true);
                }
                break;
        }
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

    public void change(View view) {
        tempNum = Double.parseDouble(temp.getText().toString());

        Intent intent = new Intent(this, ChangeTemp.class);
        Bundle b = new Bundle();
        b.putDouble("tempNum", tempNum);
        startActivity(intent);


    }
}
