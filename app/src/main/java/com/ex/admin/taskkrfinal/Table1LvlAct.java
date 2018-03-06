package com.ex.admin.taskkrfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Table1LvlAct extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1_lvl);
        listView = findViewById(R.id.idListOrder1lvl);

        MainActivity.collector.actionChoseOrder("2", this, listView, null, "to2lvl");

    }
}
