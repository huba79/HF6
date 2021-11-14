package com.example.hf6;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CurrencyListViewAdapter extends ArrayAdapter<Currency> {

    private Context context;
    private ArrayList<Currency> currencies;

    public CurrencyListViewAdapter(Context context, ArrayList<Currency> pCurrencies){
        super(context, 0,pCurrencies);
        this.context=context;
        this.currencies= pCurrencies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null)
            rowView = LayoutInflater.from(context).inflate(R.layout.currency_list_item,parent,false);

        Currency currency = currencies.get(position);

        ImageView zaszloIkonMezo = rowView.findViewById(R.id.currenciesCountryFlagViewID);
        zaszloIkonMezo.setImageResource(currency.getFlag());
        TextView valutakodMezo =  rowView.findViewById(R.id.currenciesCurrencyShortCodeDisplayID);
        valutakodMezo.setText(currencies.get(position).getCurrencyCode());
        TextView valutaNevMezo = rowView.findViewById(R.id.currenciesCurrencyNameDisplayID);
        valutaNevMezo.setText(currencies.get(position).getCurrencyName());

        return rowView;
    }
}
