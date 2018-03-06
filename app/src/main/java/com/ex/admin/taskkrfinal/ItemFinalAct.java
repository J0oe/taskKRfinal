package com.ex.admin.taskkrfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ItemFinalAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_final);

        Bundle bundle = getIntent().getExtras();
        String idParent = bundle.getString("idParent");
        ListView listView = findViewById(R.id.idItemFinal);
        MainActivity.collector.actionGetItem(this,listView,idParent);
    }
}
