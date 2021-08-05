package com.example.swoopos;

import
        android.app.AlertDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.loginapp.R;


public class Ftab1 extends Fragment {

    private Button mOpenDialog,mOpenPopup;
    private TextView mInputDisplay;
    private RadioButton radioButton1, radioButton2;
    private LinearLayout linearLayout,linearLayout3;
    private LinearLayout Android2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_ftab1,container,false);
        radioButton2 = view.findViewById(R.id.radio2);
        radioButton1 =view.findViewById(R.id.radio1);
        linearLayout = view.findViewById(R.id.Android);
        Android2 =view.findViewById(R.id.Android1);
        linearLayout3=view.findViewById(R.id.Linear3);
        mOpenPopup =(Button)view.findViewById(R.id.new_button);
        mOpenDialog = (Button)view.findViewById(R.id.btnShowDialog);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MyDialogFragment myDialogFragment = new MyDialogFragment();
               myDialogFragment.show(getActivity().getSupportFragmentManager(),"MyFragment" );
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.VISIBLE);

            }
        });
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout3.setVisibility(View.GONE);

            }
        });
                return view;

    }
}
