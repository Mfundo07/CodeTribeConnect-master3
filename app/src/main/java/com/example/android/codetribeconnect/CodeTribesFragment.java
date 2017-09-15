package com.example.android.codetribeconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by RP on 2017/09/02.
 */

public class CodeTribesFragment extends Fragment {
    private Button soweto;
    private Button tembisa;
    private Button pretoria;
    private Button alex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_codetribes,container, false);
        soweto = rootView.findViewById(R.id.codeTribe_soweto);
        tembisa = rootView.findViewById(R.id.codeTribe_tembisa);
        pretoria = rootView.findViewById(R.id.codeTribe_pretoria);
        alex = rootView.findViewById(R.id.codeTribe_alex);

        soweto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getActivity(),ActiveUserActivity.class);
                startActivity(intent);
            }
        });
        tembisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ActiveUserActivity.class);
                startActivity(intent);
            }
        });
        alex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ActiveUserActivity.class);
                startActivity(intent);
            }
        });
        pretoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ActiveUserActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
