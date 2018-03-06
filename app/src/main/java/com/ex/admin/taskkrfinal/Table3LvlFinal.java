package com.ex.admin.taskkrfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Table3LvlFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table3_lvl_final);
        Bundle bundle = getIntent().getExtras();
        String idParent = bundle.getString("idParent");
        ListView listView = findViewById(R.id.idListOrder3lvl);
        MainActivity.collector.actionChoseOrder(idParent, this, listView, null, "toItemlvl");


    }
}
