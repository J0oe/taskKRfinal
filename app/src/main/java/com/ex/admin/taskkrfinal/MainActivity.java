package com.ex.admin.taskkrfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static Collector collector;
    EditText editTextLogin;
    EditText editTextPassword;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        collector = new Collector();
    }

    public void onClickCheck(View view) {
        collector.actionLogin("58445", "36616", this, "to1lvl");
    }


    public void onClickLogin(View view) {
        editTextLogin = findViewById(R.id.idLog);
        editTextPassword = findViewById(R.id.idPass);
        if (editTextPassword.getText().toString().equals("") && editTextPassword.getText().toString().equals("")) {
        }else {
            collector.actionLogin(editTextLogin.getText().toString(), editTextPassword.getText().toString(), this, "to1lvl");

        }
    }

}