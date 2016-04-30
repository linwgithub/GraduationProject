package cn.studyjams.s1.sj21.linwei.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.studyjams.s1.sj21.linwei.R;
import cn.studyjams.s1.sj21.linwei.util.KShareViewActivityManager;

/**
 * Created by linw on 16/4/29
 * 22:41.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ICON = "extra_icon";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_VIEW_ID = "extra_view_id";
    ImageView imageview;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageview = (ImageView) findViewById(R.id.img_detail);
        title = (TextView) findViewById(R.id.tv_detail);

        int icon = getIntent().getIntExtra(EXTRA_ICON, R.mipmap.ic_launcher);
        imageview.setImageResource(icon);

        String titlestr = getIntent().getStringExtra(EXTRA_TITLE);
        title.setText(titlestr);

        int view_ids = getIntent().getIntExtra(EXTRA_VIEW_ID, R.layout.detil_getdata_fail_ayout);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.view_detail_content);
        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(view_ids, frameLayout);
    }

    @Override
    public void onBackPressed() {
        KShareViewActivityManager.getInstance(this).finish(this);
    }
}