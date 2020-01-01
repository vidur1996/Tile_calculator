package com.vidu.tilecalculator;

import androidx.appcompat.app.AppCompatActivity;
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


        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText  width_txt = (EditText) findViewById(R.id.width_txt);
                EditText  length_txt = (EditText) findViewById(R.id.length_txt);
                TextView area_txt = (TextView) findViewById(R.id.area);
                TextView tile_txt = (TextView) findViewById(R.id.tile);
                TextView appx_tile = (TextView) findViewById(R.id.appx_tile);


                if (length_txt.getText().toString() == null || length_txt.getText().toString().equals("")) {
                    Toast.makeText(floortile.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (width_txt.getText().toString() == null || width_txt.getText().toString().equals("")) {
                    Toast.makeText(floortile.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

               else {


                    int length = Integer.parseInt(length_txt.getText().toString());
                    int width = Integer.parseInt(width_txt.getText().toString());
                    String text = spin1.getSelectedItem().toString();
                    int i = 0;
                    char t = text.charAt(i);
                    int total = cal_tile.cal(t, width, length);
                    int area = length * width;

                    tile_txt.setText(total + "");
                    area_txt.setText(area + "");
                    appx_tile.setText((total + 10) + "");


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
