package edu.temple.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by Mitra on 2/12/17.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] colors;

    //constructor
    public CustomAdapter(Context c, String[] colors){
        this.context = c;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //create a textview, then want to see its value to be the text from collections

        TextView textView = new TextView(this.context);
        textView.setTextSize(20);
        textView.setText(colors[position]);
        textView.setBackgroundColor(Color.parseColor(colors[position]));

       try {
           textView.setBackgroundColor(Color.parseColor(colors[position]));
       }catch(Exception e){

       }

        return textView;
    }

}
