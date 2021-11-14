package com.example.hf6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrencyFragment extends Fragment {
    Currency currency;

    public static CurrencyFragment newInstance(Currency pCurrency) {
        CurrencyFragment cf = new CurrencyFragment();
        Bundle args = new Bundle();
        Currency currency;
        if (pCurrency==null) {
            currency=new Currency(R.drawable.europe,"Euro", "EUR", 4.9999,4.9000);
        } else{
            currency = pCurrency;
        }
        args.putSerializable("currency", currency);
        cf.setArguments(args);
        Log.d("status:","NewInstance method used");
        return cf;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View currencyView = inflater.inflate(R.layout.fragment_currency, container, false);

        Bundle args = this.getArguments();
        if (args==null) {
            currency = new Currency(R.drawable.europe, "Euro", "EUR", 4.9999, 4.9000);
        } else {
            currency = (Currency) args.getSerializable("currency");
        }

        // Inflate the layout for this fragment

        ( (ImageView) currencyView.findViewById(R.id.flagDisplayID) ).setImageResource(currency.getFlag());
        ( (TextView) currencyView.findViewById(R.id.currencyNameViewID) ).setText(currency.getCurrencyName());
        ( (TextView) currencyView.findViewById(R.id.currencyCodeViewID) ).setText(currency.getCurrencyCode());
        ( (TextView) currencyView.findViewById(R.id.sellPriceLabelID) ).setText("We sell:");
        ( (TextView) currencyView.findViewById(R.id.buyPriceLabelID) ).setText("We buy :");
        ( (TextView) currencyView.findViewById(R.id.sellPriceDisplayID) ).setText(String.valueOf(currency.getSellRate()));
        ( (TextView) currencyView.findViewById(R.id.buyPriceDisplayID) ).setText(String.valueOf( currency.getBuyRate()) );
        return currencyView;
    }
}