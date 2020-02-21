package com.vidu.tilecalculator;

public class cal_tile {

    public static int w_total =0;
    public static int l_total =0;

    public  static int cal(char text, int width, int length)

    {
        int total =0;
        int width_inch = width;
        int length_inch = length;

        if(text=='1')
        {
            w_total = width_inch/6 ;
            if(width_inch%6!=0)
            {
                w_total = w_total+1;
            }

            l_total = length_inch/6 ;
            if(length_inch%6!=0)
            {
                l_total = l_total+1;
            }
            total = l_total*w_total;
        }
        else if(text=='2')
        {
             w_total = width_inch/9 ;
            if(width_inch%9!=0)
            {
                w_total = w_total+1;
            }

             l_total = length_inch/9 ;
            if(length_inch%9!=0)
            {
                l_total = l_total+1;
            }
            total = l_total*l_total;
        }

        else if(text=='3')
        {
             w_total = width_inch/12 ;
            if(width_inch%12!=0)
            {
                w_total = w_total+1;
            }

             l_total = length_inch/12 ;
            if(length_inch%12!=0)
            {
                l_total = l_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='4')
        {
             w_total = width_inch/16 ;
            if(width_inch%16!=0)
            {
                w_total = w_total+1;
            }

             l_total = length_inch/16 ;
            if(length_inch%16!=0)
            {
                l_total = l_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='5')
        {
             w_total = width_inch/18 ;
            if(width_inch%18!=0)
            {
                w_total = w_total+1;
            }

             l_total = length_inch/18 ;
            if(length_inch%18!=0)
            {
                l_total = l_total+1;
            }
            total = l_total*w_total;
        }

        else if(text=='6')
        {
             w_total = width_inch/24 ;
            if(width_inch%24!=0)
            {
                w_total = w_total+1;
            }

             l_total = length_inch/24 ;
            if(length_inch%24!=0)
            {
                l_total = l_total+1;
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
