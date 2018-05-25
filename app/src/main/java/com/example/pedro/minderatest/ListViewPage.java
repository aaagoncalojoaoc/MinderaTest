package com.example.pedro.minderatest;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.pedro.minderatest.MainActivity.EXTRA_MESSAGE;
import static com.example.pedro.minderatest.MainActivity.EXTRA_MESSAGE_2;

public class ListViewPage extends AppCompatActivity {

    ListView root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_page);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barBackgroundColor)));

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        getSupportActionBar().setTitle(message);

        root = (ListView) findViewById(R.id.listView);

        String [] list = new String[15];
        for(int i=0;i<list.length;i++){
            String j = String.valueOf(i+1);
            if(j.length()<2) j = "0"+j;
            list[i] = "List "+j;
        }

        populateListView(list);
        registerClickCallback();


    }


    private void populateListView(String[] items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_items , items);
        root.setAdapter(arrayAdapter);
    }

    private void registerClickCallback() {
        root.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewPage.this,GridViewPage.class);
                String name = ((TextView) view).getText().toString();
                intent.putExtra(EXTRA_MESSAGE_2,name);
                startActivity(intent);
            }
        });

    }

}
