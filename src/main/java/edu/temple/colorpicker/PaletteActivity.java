package edu.temple.colorpicker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PaletteActivity extends Activity{

    View myLayout;
    Spinner spinner;
    boolean firstClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


    /*
    need to provide our spinner with children. To do this we need an adapter. We can use a predefined
    adapter that comes with android. It is called an ArrayAdapter. Will take an array, take a layout
    that tells it what the views should look like and creates an adapter.
    First create a String array...
     */
        firstClick = false;
        final String[] myColors = {"Red", "Blue", "Green", "Gray", "Cyan", "Magenta", "Yellow"};

        //connects to the Spinner/activity_palette.xml
        spinner = (Spinner)findViewById(R.id.spinner);
        myLayout = findViewById(R.id.activity_palette);

        CustomAdapter customAdapter = new CustomAdapter(this, myColors);

        //tell our spinner to use our custom adapter now
        spinner.setAdapter(customAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstClick) {
                    try {
                        myLayout.setBackgroundColor(Color.parseColor(myColors[position]));
                    } catch (Exception e) {

                    }
                }else{
                    firstClick = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }


}
