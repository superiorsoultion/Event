package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.event.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Usman on 5/6/2015.
 */
public class CalenderAdapter extends BaseAdapter{
    private final LayoutInflater inflater;
    int monthNumber;
    int year;
    Context con;
    ArrayList<Integer>items;
    int count;
    public CalenderAdapter(Context con,int monthNumber,int year){
        items=new ArrayList<>();
        this.monthNumber=monthNumber;
        this.year=year;
        this.con=con;
        inflater = LayoutInflater.from(con);
        count=getDaysInMonth(monthNumber,year);
        for (int i = 0; i < count; i++) {
            items.add(i+1);
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      //  final News tile = tilesList.get(arg0);
        ViewHolder holder;
        // SquareImageView imageView;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout, parent, false);
            holder = new ViewHolder();// if it's not recycled, initialize some
            // attributes
            // imageView = new SquareImageView(mContext);
            // imageView.setLayoutParams(new GridView.LayoutParams(, ));
          //  holder.img = (ImageView) convertView.findViewById(R.id.item);
            holder.txt_title = (TextView) convertView.findViewById(R.id.textView_value);
            //holder.img.setScaleType(ImageView.ScaleType.FIT_XY);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //convertView.setBackgroundResource(R.drawable.day_schedualar_icon);
        holder.txt_title.setText(String.valueOf(items.get(position)));


        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView txt_title;
    }

    public  int getDaysInMonth(int monthNumber,int year)
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
