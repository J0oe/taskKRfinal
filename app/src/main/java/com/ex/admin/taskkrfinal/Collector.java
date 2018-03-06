package com.ex.admin.taskkrfinal;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Admin on 04.03.2018.
 */

public class Collector implements ICollector {
    Worker worker = new Worker();

    @Override
    public void actionLogin(String kodName, String pasName, Context context, String act) {
        worker.checkDateAcc(kodName, pasName, context, act);
    }


    @Override
    public void actionChoseOrder(String idParent, final Context context, final ListView listView, Response<List<OrdersApi>> response, final String act) {
        worker.showMeDouOrder(idParent, context, listView, response, act);
    }

    @Override
    public void actionGetItem(Context context, ListView listView, String idItem) {
        worker.showMeItem(context, listView, idItem);
    }


}
