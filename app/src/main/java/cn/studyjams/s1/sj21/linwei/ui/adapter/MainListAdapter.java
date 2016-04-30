package cn.studyjams.s1.sj21.linwei.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.studyjams.s1.sj21.linwei.R;

/**
 * 作者: pollysoft
 * 时间: 16/4/28
 * 内容:
 */
public class MainListAdapter extends BaseAdapter {

    String[] titles;
    int[] img_isd;
    Activity activity;

    public MainListAdapter(Activity activity, String[] titles, int[] img_isd) {

        this.activity = activity;
        this.titles = titles;
        this.img_isd = img_isd;
    }

    @Override
    public int getCount() {
        return titles != null ? titles.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_main_list_layout, null);

            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(R.id.img_main_list_item, viewHolder.imageView);
            convertView.setTag(R.id.tv_main_list_item, viewHolder.textView);
            convertView.setTag(R.layout.item_main_list_layout,viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag(R.layout.item_main_list_layout);
        }

        viewHolder.imageView.setImageResource(img_isd[position]);
        viewHolder.textView.setText(titles[position]);

        return convertView;
    }

    class MyViewHolder{
        ImageView imageView;
        TextView textView;

        public MyViewHolder(View convertView) {
            this.imageView = (ImageView) convertView.findViewById(R.id.img_main_list_item);

            this.textView = (TextView) convertView.findViewById(R.id.tv_main_list_item);
        }
    }
}
