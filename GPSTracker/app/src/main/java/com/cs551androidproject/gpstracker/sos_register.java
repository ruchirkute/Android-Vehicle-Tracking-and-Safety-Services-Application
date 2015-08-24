package com.cs551androidproject.gpstracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class sos_register extends ActionBarActivity {

    Button registerSOS;
    EditText ed,ed1,ed2;
    private String file = "eContactFile";
    String data;
    int c;
    String temp="";
    boolean changeButtonName=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_register);
        registerSOS=(Button) findViewById(R.id.button);
        ed=(EditText) findViewById(R.id.editText);
        ed1=(EditText) findViewById(R.id.editText1);
        ed2=(EditText) findViewById(R.id.editText2);

        //Read dta from same file
        try{
            FileInputStream fin = openFileInput(file);
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
                changeButtonName=true;

            }
            if(changeButtonName) {
                String savedNumbers[] = temp.split("----");
                ed.setText(savedNumbers[0]);
                ed1.setText(savedNumbers[1]);
                ed2.setText(savedNumbers[2]);
                registerSOS.setText("Update");
            }
        }
        catch(Exception e){
        }

        registerSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    data = ed.getText().toString() + " ----" + ed1.getText().toString() + " ----" + ed2.getText().toString()+" ";
                    try {
                        FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
                        fOut.write(data.getBytes());
                        fOut.close();
                        Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finish();
                }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sos_register, menu);
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
