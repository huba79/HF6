package com.example.hf6;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CurrenciesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment_currencies, container, false);


        ListView currencyList = (ListView) vw.findViewById(R.id.currencyListViewID);
        ArrayList<Currency> currencies = prepareCurrencyList();

        CurrencyListViewAdapter currencyListAdapter= new CurrencyListViewAdapter(c, currencies);
        currencyList.setAdapter(currencyListAdapter);
        Log.d("currencies",currencies.toString());

        final FragmentManager fragmentManager = getFragmentManager();
        currencyList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                CurrencyFragment fragment  = (CurrencyFragment)fragmentManager.findFragmentByTag("currencyFragment");

                int orientation = getResources().getConfiguration().orientation;
                if (orientation == ORIENTATION_LANDSCAPE){
                    View currencyView = fragment.getView();
                    ( (ImageView) currencyView.findViewById(R.id.flagDisplayID) ).setImageResource(currencies.get(position).getFlag());
                    ( (TextView) currencyView.findViewById(R.id.currencyNameViewID) ).setText(currencies.get(position).getCurrencyName());
                    ( (TextView) currencyView.findViewById(R.id.currencyCodeViewID) ).setText(currencies.get(position).getCurrencyCode());
                    ( (TextView) currencyView.findViewById(R.id.sellPriceLabelID) ).setText("We sell:");
                    ( (TextView) currencyView.findViewById(R.id.buyPriceLabelID) ).setText("We buy :");
                    ( (TextView) currencyView.findViewById(R.id.sellPriceDisplayID) ).setText(String.valueOf(currencies.get(position).getSellRate()));
                    ( (TextView) currencyView.findViewById(R.id.buyPriceDisplayID) ).setText(String.valueOf( currencies.get(position).getBuyRate()) );

                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(),  CurrencyDetailActivity.class);
                    intent.putExtra("currency", currencies.get(position));
                    startActivity(intent);
                }
            }
        });
        return vw;
    }

    private ArrayList<Currency> prepareCurrencyList(){
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency(R.drawable.belgium,"Euro", "EUR", 4.9999,4.9000));
        currencies.add(new Currency(R.drawable.croatia,"Kuna", "HRK", 3.2,3.0));
        currencies.add(new Currency(R.drawable.hungary,"Forint", "HUF", 0.068,0.067));
        currencies.add(new Currency(R.drawable.srilanka,"Picula", "PIC", 0.028,0.267));
        currencies.add(new Currency(R.drawable.sudan,"Mutembe", "MTB", 0.008,0.0067));
        currencies.add(new Currency(R.drawable.moldova,"Moldavian LEU", "MDL", 0.26,0.25));
        currencies.add(new Currency(R.drawable.europe,"Euro", "EUR", 4.9999,4.9000));
        currencies.add(new Currency(R.drawable.togo,"Mittomen", "MTM", 0.008,0.0067));
        return currencies;
    }
}