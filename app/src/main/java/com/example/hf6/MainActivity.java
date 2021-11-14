package com.example.hf6;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == ORIENTATION_LANDSCAPE) setContentView(R.layout.activity_main_landscape);
        else setContentView(R.layout.activity_main_portrait);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (orientation == ORIENTATION_LANDSCAPE){ //==2
            Log.d("screenorientation","screenorientation:ORIENTATION_LANDSCAPE, setting the 2 fragments");
            if(getSupportFragmentManager().findFragmentByTag("currenciesFragment")==null
                    && getSupportFragmentManager().findFragmentByTag("currencyFragment")==null){
                fragmentTransaction.add(R.id.landscapeCurrenciesFragmentViewID,new CurrenciesFragment(),"currenciesFragment");
                fragmentTransaction.add(R.id.landscapeCurrencyFragmentViewID,  new CurrencyFragment(),"currencyFragment");
            }
        } else {
            Log.d("screenorientation","screenorientation:NOT_LANDSCAPE, setting only list fragment");
            if(getSupportFragmentManager().findFragmentByTag("currenciesFragment")==null)
                fragmentTransaction.add(R.id.portraitCurrenciesFragmentViewID, new CurrenciesFragment(), "currenciesFragment");
        }
        fragmentTransaction.commit();
    }

//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        if (newConfig.orientation == ORIENTATION_LANDSCAPE) setContentView(R.layout.activity_main_landscape);
//        else setContentView(R.layout.activity_main_portrait);
//    }
}