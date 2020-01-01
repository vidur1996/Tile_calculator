package com.vidu.tilecalculator;

public class cal_tile {

    public static int cal(char text, int width, int length)

    {
        int total =0;
        int width_inch = width*12;
        int length_inch = length*12;

        if(text=='1')
        {
            int w_total = width_inch/6 ;
            if(width_inch%6!=0)
            {
                w_total = w_total+1;
            }

            int l_total = length_inch/6 ;
            if(length_inch%6!=0)
            {
                l_total = w_total+1;
            }
            total = l_total*w_total;
        }
        else if(text=='2')
        {
            int w_total = width_inch/9 ;
            if(width_inch%9!=0)
            {
                w_total = w_total+1;
            }

            int l_total = length_inch/9 ;
            if(length_inch%9!=0)
            {
                l_total = w_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='3')
        {
            int w_total = width_inch/12 ;
            if(width_inch%12!=0)
            {
                w_total = w_total+1;
            }

            int l_total = length_inch/12 ;
            if(length_inch%12!=0)
            {
                l_total = w_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='4')
        {
            int w_total = width_inch/16 ;
            if(width_inch%16!=0)
            {
                w_total = w_total+1;
            }

            int l_total = length_inch/12 ;
            if(length_inch%12!=0)
            {
                l_total = w_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='5')
        {
            int w_total = width_inch/18 ;
            if(width_inch%18!=0)
            {
                w_total = w_total+1;
            }

            int l_total = length_inch/18 ;
            if(length_inch%18!=0)
            {
                l_total = w_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='6')
        {
            int w_total = width_inch/24 ;
            if(width_inch%24!=0)
            {
                w_total = w_total+1;
            }

            int l_total = length_inch/24 ;
            if(length_inch%24!=0)
            {
                l_total = w_total+1;
            }
            total = l_total*w_total;
        }

        else
        {
            total = 0;
        }









        return total;
    }


}
