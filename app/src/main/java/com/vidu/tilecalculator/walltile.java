package com.vidu.tilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class walltile extends AppCompatActivity {

    Spinner spin1;
    Spinner spin2;
    Spinner spin_3;
    Spinner spin_4;
    TextView area_txt1;
    TextView area_txt2;
    TextView tile_txt1;
    TextView tile_txt2;
    TextView declare;
    TextView  sam1;
    TextView sam2;
    int ori_val;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walltile);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);



        final Button cal_btn = (Button) findViewById(R.id.cal_btn);
        spin1 = (Spinner) findViewById(R.id.spin1);
        spin2 = (Spinner) findViewById(R.id.spin2);
        spin_3 = (Spinner) findViewById(R.id.spin4);
        spin_4 = (Spinner) findViewById(R.id.spin3);
        area_txt1 = (TextView) findViewById(R.id.area_txt);
        area_txt2 = (TextView) findViewById(R.id.area_txt2);
        tile_txt1 = (TextView) findViewById(R.id.tile_txt);
        tile_txt2 = (TextView) findViewById(R.id.tile_txt2);
        declare = (TextView) findViewById(R.id.declare);

           sam2 = (TextView) findViewById(R.id.sample2) ;
        area_txt1.setVisibility(TextView.INVISIBLE);
        area_txt2.setVisibility(TextView.INVISIBLE);
        tile_txt1.setVisibility(TextView.INVISIBLE);
        tile_txt2.setVisibility(TextView.INVISIBLE);
        declare.setVisibility(TextView.INVISIBLE);

        ArrayAdapter<String> myadapter1  = new ArrayAdapter<String>(walltile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.wall_size));
        myadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(myadapter1);

        ArrayAdapter<String> myadapter2  = new ArrayAdapter<String>(walltile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.orientation));
        myadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(myadapter2);

        ArrayAdapter<String> myadapter3 = new ArrayAdapter<String>(walltile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.measurement));
        myadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_3.setAdapter(myadapter3);


        ArrayAdapter<String> myadapter4 = new ArrayAdapter<String>(walltile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.measurement));
        myadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_4.setAdapter(myadapter3);

        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText width_txt = (EditText) findViewById(R.id.width_txt);
                EditText  length_txt = (EditText) findViewById(R.id.length_txt);
                TextView area_txt = (TextView) findViewById(R.id.area);
                TextView tile_txt = (TextView) findViewById(R.id.tile);
                TextView appx_tile = (TextView) findViewById(R.id.appx_tile);

                String text =  spin1.getSelectedItem().toString();
                String ori = spin2.getSelectedItem().toString();
                String h_measure  = spin_3.getSelectedItem().toString();
                String w_measure  = spin_4.getSelectedItem().toString();

                if(ori.equals("LANDSCAPE"))
                {
                    ori_val=1;
                }
                else if(ori.equals("PORTRIAL"))
                {
                    ori_val =2;

                }





                if (length_txt.getText().toString() == null || length_txt.getText().toString().equals("")) {
                    Toast.makeText(walltile.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (width_txt.getText().toString() == null || width_txt.getText().toString().equals("")) {
                    Toast.makeText(walltile.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {


                    double heigth = Double.parseDouble(length_txt.getText().toString());
                    double width = Double.parseDouble(width_txt.getText().toString());

                    width = convertion.convert_w(w_measure,width);
                    heigth = convertion.convert_h(h_measure,heigth);

                    int i = 0;
                    char t = text.charAt(i);
                    double total = wall_cal_tile.cal(t, (int)width, (int)heigth,ori_val);
                    double area = (heigth/12) * (width/12);
                    area = area *100;
                    area = Math.round(area);
                    area = area/100;

                    tile_txt.setText(Math.round(total) + "");
                    area_txt.setText(area + "");
                    if(wall_cal_tile.l_total > wall_cal_tile.w_total)
                    {
                        appx_tile.setText((Math.round(total) + wall_cal_tile.l_total ) + "");
                    }
                    else
                    {
                        appx_tile.setText((Math.round(total) + wall_cal_tile.w_total ) + "");
                    }


                    try {
                        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    area_txt1.setVisibility(TextView.VISIBLE);
                    area_txt2.setVisibility(TextView.VISIBLE);
                    tile_txt1.setVisibility(TextView.VISIBLE);
                    area_txt2.setVisibility(TextView.VISIBLE);
                    declare.setVisibility(TextView.VISIBLE);
                }
            }
        });
    }
}
