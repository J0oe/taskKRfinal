package com.ex.admin.taskkrfinal;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 04.03.2018.
 */

public class Worker implements IWorker {


    //check acc date
    @Override
    public void checkDateAcc(String kodName, String pasName, final Context context, final String act) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://stozhary.net.ua/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IServerApi messagesApi = retrofit.create(IServerApi.class);
        Call<DateApi> dateApiCall = messagesApi.messages(kodName, pasName);
        dateApiCall.enqueue(new Callback<DateApi>() {

            @Override
            public void onResponse(Call<DateApi> call, Response<DateApi> response) {
                if (response.body().getName().equals("FAILED")) {
                    Toast.makeText(context, "wrong date", Toast.LENGTH_LONG).show();
                } else {
                    moveToNextAct(context, act, null);
                }
            }

            @Override
            public void onFailure(Call<DateApi> call, Throwable t) {

            }
        });

    }


    //make 1-3lvl list order
    @Override
    public void showMeDouOrder(final String idParent, final Context context, final ListView listView, Response<List<OrdersApi>> response, final String act) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://stozhary.net.ua/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IServerApi messagesApi = retrofit.create(IServerApi.class);
        Call<List<OrdersApi>> dateApiCall = messagesApi.groupOrder(idParent);
        dateApiCall.enqueue(new Callback<List<OrdersApi>>() {
            @Override
            public void onResponse(Call<List<OrdersApi>> call, Response<List<OrdersApi>> response) {
                if (response.body().isEmpty()) {
                    Log.d("Error", "empty");
                } else {
                    makeAdapter(context, listView, response, act);
                }
            }

            @Override
            public void onFailure(Call<List<OrdersApi>> call, Throwable t) {

            }
        });
    }

    //make item list
    @Override
    public void showMeItem(final Context context, final ListView listView, String idItem) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://stozhary.net.ua/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IServerApi messagesApi = retrofit.create(IServerApi.class);
        Call<List<ItemApi>> dateApiCall = messagesApi.itemOrder(idItem);
        dateApiCall.enqueue(new Callback<List<ItemApi>>() {

            @Override
            public void onResponse(Call<List<ItemApi>> call, Response<List<ItemApi>> response) {
                makeItemAdapter(context, listView, response);
            }

            @Override
            public void onFailure(Call<List<ItemApi>> call, Throwable t) {

            }
        });
    }


    //to new Activity
    private void moveToNextAct(Context context, String act, String bundle) {
        Intent intent;


        if (act == null) {
        }
        if (act.equals("to1lvl")) {
            context.startActivity(new Intent(context, Table1LvlAct.class));
        }
        if (act.equals("to2lvl")) {
            intent = new Intent(context, Table2LvlAct.class);
            if (bundle != null) {
                intent.putExtra("idParent", bundle);
            }
            context.startActivity(intent);
        }
        if (act.equals("to3lvl")) {
            intent = new Intent(context, Table3LvlFinal.class);
            if (bundle != null) {
                intent.putExtra("idParent", bundle);
            }
            context.startActivity(intent);
        }
        if (act.equals("toItemlvl")) {
            intent = new Intent(context, ItemFinalAct.class);
            if (bundle != null) {
                intent.putExtra("idParent", bundle);
            }

            context.startActivity(intent);
        }
    }


    //adapter for orders list
    private void makeAdapter(final Context context, ListView listView, final Response<List<OrdersApi>> response, final String act) {
        OrderAdapter boxAdapter = new OrderAdapter(context, response.body());
        listView.setAdapter(boxAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String bundle = response.body().get(position).getID();
                moveToNextAct(context, act, bundle);

            }
        });
    }

    //adapter for item list
    private void makeItemAdapter(final Context context, ListView listView, final Response<List<ItemApi>> response) {
        ItemAdapter boxAdapter = new ItemAdapter(context, response.body());
        listView.setAdapter(boxAdapter);
    }

}