package com.ex.admin.taskkrfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 04.03.2018.
 */

public class OrderAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    List<OrdersApi> objects;

    OrderAdapter(Context context, List<OrdersApi> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        OrdersApi p = getProduct(position);

        ((TextView) view.findViewById(R.id.idNameOrder)).setText(p.getName());
        ((TextView) view.findViewById(R.id.idIDorder)).setText(p.getID());
        ((TextView) view.findViewById(R.id.idParentIDOrder)).setText(p.getParentID());

        return view;

    }

    OrdersApi getProduct(int position) {
        return ((OrdersApi) getItem(position));
    }

}
