package com.example.jangir.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class dataAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<DataModelClass> arrayList;

        public dataAdapter(Context c, ArrayList arrayList ) {
            mContext = c;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View grid;
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                grid = new View(mContext);
                DataModelClass dataModelClass = arrayList.get(position);
                grid = inflater.inflate(R.layout.grid, null);
                TextView textView = (TextView) grid.findViewById(R.id.title);
                TextView textView1 = (TextView) grid.findViewById(R.id.note);
                ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
                textView.setText(dataModelClass.getTitle());
                textView1.setText(dataModelClass.getContent());
              //  imageView.setImageResource(Image[position]);
            } else {
                grid = (View) convertView;
            }

            return grid;
        }
    }
