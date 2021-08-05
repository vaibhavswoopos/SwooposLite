package com.example.swoopos;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.loginapp.R;

import org.jetbrains.annotations.NotNull;

public class MyDialogFragment extends DialogFragment {
    Button btn;

    String[] Spinner_Items;
    TextView display, selected;
    String result;
    Spinner spinner,spinner1 ;
    LinearLayout linearLayout,linearLayout1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialog_fragment, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.Spinner);
        Spinner spinner1 = (Spinner) view.findViewById(R.id.Spinner1);
        Button button = (Button)view.findViewById(R.id.btn_1);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.Free);
        LinearLayout linearLayout1 = (LinearLayout)view.findViewById(R.id.relative1);
        TextView textView = (TextView) view.findViewById(R.id.display);
        TextView textView1 = (TextView) view.findViewById(R.id.display1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Spinner_Items,
                R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.Spinner_Items1,
                R.layout.color_spinner_layout);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner1.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectItem = adapterView.getItemAtPosition(position).toString();
                textView.setText(selectItem);
                if (position== 0){
                    linearLayout1.setVisibility(View.GONE);
                }else {
                    linearLayout1.setVisibility(View.VISIBLE);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectItem = adapterView.getItemAtPosition(position).toString();
                textView1.setText(selectItem);
                linearLayout1.setVisibility(View.VISIBLE);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });




        return view;
    }



}

