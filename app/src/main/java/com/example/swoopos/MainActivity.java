package com.example.swoopos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.R;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btSignIn;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSignIn = findViewById(R.id.bt_signin);
        recyclerView = findViewById(R.id.recyclerView);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("swoope@gmail.com") &&
                        etPassword.getText().toString().equals("12345")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_baseline_check_circle_24);
                    builder.setTitle("Login Successful !!!");
                    builder.setMessage("Welcome to Swoope Lite..");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            Intent intent = new Intent(MainActivity.this, Navigation.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username & Password", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}




