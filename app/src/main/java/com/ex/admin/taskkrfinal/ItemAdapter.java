package com.ex.admin.taskkrfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 05.03.2018.
 */

public class ItemAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    List<ItemApi> objects;

    ItemAdapter(Context context, List<ItemApi> products) {
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
            view = lInflater.inflate(R.layout.item_item, parent, false);
        }

        ItemApi p = getProduct(position);

        ((TextView) view.findViewById(R.id.idNameItem)).setText(p.getName());
        ((TextView) view.findViewById(R.id.idPriceItem)).setText(p.getPrice());


        Glide
                .with(ctx)
                .load(p.getImage())
                .into(((ImageView) view.findViewById(R.id.idImageItem)));


        return view;

    }

    ItemApi getProduct(int position) {
        return ((ItemApi) getItem(position));
    }

}