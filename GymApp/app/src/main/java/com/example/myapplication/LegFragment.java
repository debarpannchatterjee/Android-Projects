package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class LegFragment extends Fragment {
    Button button;
    TextView tvlegs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leg, container, false);

        button = (Button) view.findViewById(R.id.button);
        tvlegs = (TextView) view.findViewById(R.id.tvlegs);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = tvlegs.getText().toString();
                Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,message);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        return view;
    }
}