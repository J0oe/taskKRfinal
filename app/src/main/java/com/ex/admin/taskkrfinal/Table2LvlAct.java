package com.ex.admin.taskkrfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class Table2LvlAct extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2_lvl);
        Bundle bundle = getIntent().getExtras();
        String idParent = bundle.getString("idParent");
        ListView listView = findViewById(R.id.idListOrder2Lvl);
        MainActivity.collector.actionChoseOrder(idParent, this, listView, null, "to3lvl");
    }
}
