package cn.studyjams.s1.sj21.linwei.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import cn.studyjams.s1.sj21.linwei.R;
import cn.studyjams.s1.sj21.linwei.ui.adapter.MainListAdapter;
import cn.studyjams.s1.sj21.linwei.util.KShareViewActivityManager;

public class MainActivity extends AppCompatActivity {

    int[] view_ids = {
            R.layout.detail_1_layout,
            R.layout.detail_2_layout,
            R.layout.detail_3_layout,
            R.layout.detail_4_layout,
            R.layout.detail_5_layout
    };

    String[] titleStrs = {
            "1、认识轮滑",
            "2、轮滑鞋选购",
            "3、轮滑入门",
            "4、轮滑安全",
            "5、轮滑提高"
    };

    int[] img_ids = {
            R.drawable.main_1,
            R.drawable.main_2,
            R.drawable.main_3,
            R.drawable.main_4,
            R.drawable.main_5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_main);
        MainListAdapter adapter = new MainListAdapter(this, titleStrs, img_ids);
        if (adapter != null) listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView childImg = (ImageView) view.getTag(R.id.img_main_list_item);
                TextView childTv = (TextView) view.getTag(R.id.tv_main_list_item);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TITLE, titleStrs[position]);
                intent.putExtra(DetailActivity.EXTRA_ICON, img_ids[position]);
                intent.putExtra(DetailActivity.EXTRA_VIEW_ID, view_ids[position]);

                KShareViewActivityManager
                        .getInstance(MainActivity.this)
                        .withIntent(intent)
                        .setDuration(250)
                        .startActivity(
                                MainActivity.this,
                                DetailActivity.class,
                                R.layout.item_main_list_layout,
                                R.layout.activity_detail,
                                childImg,
                                childTv
                        );
            }
        });
    }
}
