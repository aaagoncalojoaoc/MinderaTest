package com.example.pedro.minderatest;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.pedro.minderatest.MainActivity.EXTRA_MESSAGE;


public class Tab extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int mParam1;

    public Tab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab newInstance(int param1) {
        Tab fragment = new Tab();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        if(mParam1 == 1){
            LinearLayout root = rootView.findViewById(R.id.scrollable);

            View[] v = new View[18];

            for(int i=0;i<v.length;i++){
                String j = String.valueOf(i+1);
                if(j.length()<2) j = "0"+j;
                v[i] = makeBox("Day "+j);
            }

            View[] b = {makeBox(null),makeBox(null),makeBox(null),makeBox(null),makeBox(null)};
            View[] n = {makeBox(null),makeBox(null),makeBox(null),makeBox(null),makeBox(null)};


            root.addView(makeScrollableContent("Open Day '18",v));
            root.addView(makeScrollableContent("Graduate Program",b));
            root.addView(makeScrollableContent("Meet Mindera Code & Culture ",n));
        }

        return rootView;
    }

    private LinearLayout makeBox(String text){

        LinearLayout l = new LinearLayout(getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((int)getResources().getDimension(R.dimen.scrollable_content_box_width), ViewGroup.LayoutParams.MATCH_PARENT);
        lp.setMargins(20,20,20,20);
        l.setLayoutParams(lp);
        l.setPadding(0,0,0,20);
        l.setBackgroundColor(getResources().getColor(R.color.BackgroundColor));

        if(text != null && !text.isEmpty()){
            TextView tv = new TextView(getContext());
            tv.setTextColor(getResources().getColor(R.color.white));
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setLayoutParams(lp2);
            tv.setTextSize(18);
            tv.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
            tv.setText(text);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ListViewPage.class);
                    String name;
                    name = ((TextView)((LinearLayout)v.getParent().getParent().getParent().getParent()).getChildAt(0)).getText().toString();
                    name += "_";
                    name += ((TextView)v).getText().toString();
                    intent.putExtra(EXTRA_MESSAGE,name);
                    startActivity(intent);
                }
            });

            l.addView(tv);
        }

        return l;
    }

    private LinearLayout makeScrollableContent(String title, View[] content){

        LinearLayout root = new LinearLayout(getContext());
        root.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)getResources().getDimension(R.dimen.scrollable_content_root)));
        root.setOrientation(LinearLayout.VERTICAL);

        TextView titleview = new TextView(getContext());
        titleview.setText(title);
        titleview.setTypeface(titleview.getTypeface(), Typeface.BOLD);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)getResources().getDimension(R.dimen.scrollable_content_title));
        lp.setMargins(20,0,0,0);
        titleview.setLayoutParams(lp);
        titleview.setTextSize(25);
        titleview.setGravity(Gravity.CENTER_VERTICAL);

        root.addView(titleview);

        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)getResources().getDimension(R.dimen.scrollable_content_box_height)));

        LinearLayout container = new LinearLayout(getContext());
        container.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        container.setOrientation(LinearLayout.HORIZONTAL);

        for (View ct : content) {
            container.addView(ct);
        }

        horizontalScrollView.addView(container);
        root.addView(horizontalScrollView);

        return root;
    }


}
