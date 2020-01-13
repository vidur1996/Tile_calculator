package com.vidu.tilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class floortile extends AppCompatActivity {

    Spinner spin1;
    Spinner spin_3;
    Spinner spin_4;
    TextView area_txt1;
    TextView area_txt2;
    TextView tile_txt1;
    TextView tile_txt2;
    TextView declare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floortile);

        Button cal_btn = (Button) findViewById(R.id.cal_btn);

        spin1 = (Spinner) findViewById(R.id.spin1);
        spin_3 = (Spinner) findViewById(R.id.spin4);
        spin_4 = (Spinner) findViewById(R.id.spin3);
        area_txt1 = (TextView) findViewById(R.id.area_txt);
        area_txt2 = (TextView) findViewById(R.id.area_txt2);
        tile_txt1 = (TextView) findViewById(R.id.tile_txt);
        tile_txt2 = (TextView) findViewById(R.id.tile_txt2);
        declare = (TextView) findViewById(R.id.declare);

        area_txt1.setVisibility(TextView.INVISIBLE);
        area_txt2.setVisibility(TextView.INVISIBLE);
        tile_txt1.setVisibility(TextView.INVISIBLE);
        tile_txt2.setVisibility(TextView.INVISIBLE);
        declare.setVisibility(TextView.INVISIBLE);

        ArrayAdapter<String> myadapter  = new ArrayAdapter<String>(floortile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.floor_size));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(myadapter);


        ArrayAdapter<String> myadapter3 = new ArrayAdapter<String>(floortile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.measurement));
        myadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_3.setAdapter(myadapter3);


        ArrayAdapter<String> myadapter4 = new ArrayAdapter<String>(floortile.this
                ,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.measurement));
        myadapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_4.setAdapter(myadapter3);


        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText  width_txt = (EditText) findViewById(R.id.width_txt);
                EditText  length_txt = (EditText) findViewById(R.id.length_txt);
                TextView area_txt = (TextView) findViewById(R.id.area);
                TextView tile_txt = (TextView) findViewById(R.id.tile);
                TextView appx_tile = (TextView) findViewById(R.id.appx_tile);

                String h_measure  = spin_3.getSelectedItem().toString();
                String w_measure  = spin_4.getSelectedItem().toString();


                if (length_txt.getText().toString() == null || length_txt.getText().toString().equals("")) {
                    Toast.makeText(floortile.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (width_txt.getText().toString() == null || width_txt.getText().toString().equals("")) {
                    Toast.makeText(floortile.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

               else {


                    double length = Double.parseDouble(length_txt.getText().toString());
                    double width = Double.parseDouble(width_txt.getText().toString());
                    String text = spin1.getSelectedItem().toString();

                    width = convertion.convert_w(w_measure,width);
                    length = convertion.convert_h(h_measure,length);

                    int i = 0;
                    char t = text.charAt(i);
                    int total = cal_tile.cal(t, (int)width, (int)length);
                    double area = (length/12) * (width/12);
                    area = area *100;
                    area = Math.round(area);
                    area = area/100;

                    tile_txt.setText(total + "");
                    area_txt.setText(area + "");


                    if(cal_tile.l_total > cal_tile.w_total)
                    {
                        appx_tile.setText((Math.round(total) + cal_tile.l_total ) + "");
                    }
                    else
                    {
                        appx_tile.setText((Math.round(total) + cal_tile.w_total ) + "");
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
