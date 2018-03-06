package com.ex.admin.taskkrfinal;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Admin on 04.03.2018.
 */

public interface ICollector {
    void actionLogin(String kodName, String pasName, Context context, String act);

    void actionChoseOrder(String idParent, final Context context, final ListView listView, Response<List<OrdersApi>> response, final String act);

    void actionGetItem(Context context, ListView listView, String idItem);
}
