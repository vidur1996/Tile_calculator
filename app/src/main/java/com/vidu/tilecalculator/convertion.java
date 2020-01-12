package com.vidu.tilecalculator;

public class convertion {

    public static double convert_h (String h_measure,double height)
    {
         double c_height =0;

        if(h_measure.equals("inch"))
        {
            c_height = height;
        }
        else if(h_measure.equals("meter"))
        {
            c_height = height*3.28;
        }
        else if(h_measure.equals("c.meter"))
        {
            c_height = height/100;
            c_height = c_height*3.28;
        }
        else if(h_measure.equals("feet"))
        {
            c_height = height*12;
        }
        return c_height;
    }

    public static double convert_w (String w_measure,double width)
    {
        double c_width =0;

        if(w_measure.equals("inch"))
        {
            c_width = width;
        }
        else if(w_measure.equals("meter"))
        {
            c_width = width*3.28;
        }
        else if(w_measure.equals("c.meter"))
        {
            c_width = width/100;
            c_width = c_width*3.28;
        }
        else if(w_measure.equals("feet"))
        {
            c_width = width*12;
        }
        return c_width;
    }
}
