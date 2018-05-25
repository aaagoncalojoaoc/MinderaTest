package com.example.pedro.minderatest;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.pedro.minderatest.MainActivity.EXTRA_MESSAGE_2;

public class GridViewPage extends AppCompatActivity {

    GridView root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_page);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barBackgroundColor)));

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE_2);
        getSupportActionBar().setTitle(message);

        root = (GridView) findViewById(R.id.gridView);

        String [] list = new String[15];
        for(int i=0;i<list.length;i++){
            String j = String.valueOf(i+1);
            if(j.length()<2) j = "0"+j;
            list[i] = "Description "+j;
        }
        populateGridView(list);

    }

    private void populateGridView(String[] items) {
        GridAdapter booksAdapter = new GridAdapter(this, items);
        root.setAdapter(booksAdapter);

    }



}

class GridAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] box;

    // 1
    public GridAdapter(Context context, String[] books) {
        this.mContext = context;
        this.box = books;
    }

    // 2
    @Override
    public int getCount() {
        return box.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final String square = box[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.grid_view_items, null);
        }

        final TextView textView = (TextView)convertView.findViewById(R.id.footer);
        textView.setText(square);

        return convertView;
    }

}


