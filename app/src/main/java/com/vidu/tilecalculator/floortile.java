package com.vidu.tilecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class floortile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floortile);

        Button cal_btn = (Button) findViewById(R.id.cal_btn);
        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText  width_txt = (EditText) findViewById(R.id.width_txt);
                EditText  length_txt = (EditText) findViewById(R.id.length_txt);
                TextView area_txt = (TextView) findViewById(R.id.area);
                int length = Integer.parseInt(length_txt.getText().toString());
                int width = Integer.parseInt(width_txt.getText().toString());


                int area = length * width;

                area_txt.setText(area +"");

            }
        });


    }
}
