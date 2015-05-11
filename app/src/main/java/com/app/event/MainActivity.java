package com.app.event;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.widget.GridView;

import java.util.Calendar;

import adapter.CalenderAdapter;


public class MainActivity extends ActionBarActivity {

    private Calendar mCalendar;
    private int[] mToday=new int[3];
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get date
        mCalendar = Calendar.getInstance();
        mToday[0] = mCalendar.get(Calendar.DAY_OF_MONTH);
        mToday[1] = mCalendar.get(Calendar.MONTH); // zero based
        mToday[2] = mCalendar.get(Calendar.YEAR);

        // get display metrics
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // set adapter
        mGridView = (GridView)findViewById(R.id.gridview);

        mGridView.setAdapter(new CalenderAdapter(this, mToday[1], mToday[2]));
       // Log.d("Total days",String.valueOf(getDaysInMonth(mCalendar.get(Calendar.MONTH)-1, mCalendar.get(Calendar.YEAR))));
      //  Log.d("Total days",String.valueOf(getDaysInMonth(1, 2016)));
    }
    /**
     * @param monthNumber Month Number starts with 0. For <b>January</b> it is <b>0</b> and for <b>December</b> it is <b>11</b>.
     * @param year
     * @return
     */
    public static int getDaysInMonth(int monthNumber,int year)
    {
        int days=0;
        if(monthNumber>=0 && monthNumber<12){
            try
            {
                Calendar calendar = Calendar.getInstance();
                int date = 1;
                calendar.set(year, monthNumber, date);
                days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            } catch (Exception e)
            {
                if(e!=null)
                    e.printStackTrace();
            }
        }
        return days;
    }
   
}
