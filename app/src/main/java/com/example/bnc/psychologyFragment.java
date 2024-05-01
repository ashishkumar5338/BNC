package com.example.bnc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class psychologyFragment extends Fragment {

    View root;
    TextView text,text1;
    LinearLayout linearLayout , linelayout;


    public psychologyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_psychology, container, false);
        text=root.findViewById(R.id.text);
        text1=root.findViewById(R.id.text1);
        linelayout=root.findViewById(R.id.line_layout);
        linearLayout=root.findViewById(R.id.line);

        text.setOnClickListener(v->{
            load_content(text,linelayout,text1);
        });
        text1.setOnClickListener(v->{
            load_content(text1,linearLayout,text);
        });
        return root;
    }
    boolean slide=true;
    private void load_content(View textview , View text_view ,View another_textview){
        if(slide){
            slide=false;
            textview.animate().scaleX(0.2f).setDuration(10).start();
            textview.animate().translationX(-text.getWidth()/2).setDuration(400).start();
            another_textview.setVisibility(View.GONE);
            text_view.setVisibility(View.VISIBLE);
            text_view.setTranslationX(text_view.getWidth());
            text_view.animate().translationX(140).setDuration(400).start();
        }else{
            slide=true;
            textview.animate().scaleX(1f).setDuration(400).start();
            textview.animate().translationX(0).setDuration(400).start();
            another_textview.setVisibility(View.VISIBLE);
            text_view.setVisibility(View.GONE);
        }
    }
}