package com.waitermanager.cvdevelopers.waitermanager.userdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.waitermanager.cvdevelopers.waitermanager.R;

/**
 * Created by kamiloveg1 on 4/5/15.
 */
public class MenuGridAdapter extends BaseAdapter{

    private Context mContext;
    private Integer[] imageResources;
    private String [] itemNames;
    public MenuGridAdapter(Context c, String [] itemNames, Integer [] imageResources) {
        mContext = c;
        this.imageResources = imageResources;
        this.itemNames = itemNames;
    }

    public int getCount() {
        return itemNames.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.menu_item_layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(itemNames[position]);
            imageView.setImageResource(imageResources[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}
