package com.example.hf6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrencyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish(); //landscape orientacioban nincs mirol beszeljunk :D
            return;
        }
        setContentView(R.layout.fragment_currency);
        Intent intent = getIntent();
        Currency currency = (Currency) intent.getSerializableExtra("currency");

        ( (ImageView) findViewById(R.id.flagDisplayID) ).setImageResource(currency.getFlag());
        ( (TextView) findViewById(R.id.currencyNameViewID) ).setText(currency.getCurrencyName());
        ( (TextView) findViewById(R.id.currencyCodeViewID) ).setText(currency.getCurrencyCode());
        ( (TextView) findViewById(R.id.sellPriceLabelID) ).setText("We sell:");
        ( (TextView) findViewById(R.id.buyPriceLabelID) ).setText("We buy :");
        ( (TextView) findViewById(R.id.sellPriceDisplayID) ).setText(String.valueOf(currency.getSellRate()));
        ( (TextView) findViewById(R.id.buyPriceDisplayID) ).setText(String.valueOf( currency.getBuyRate()) );
    }
}