package com.ex.admin.taskkrfinal;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Admin on 04.03.2018.
 */

public interface IWorker {

    void checkDateAcc(String kodName, String pasName, Context context, String act);

    void showMeDouOrder(String idParent, Context context, ListView listView, Response<List<OrdersApi>> response, String act);

    void showMeItem(Context context, ListView listView, String idItem);

}
