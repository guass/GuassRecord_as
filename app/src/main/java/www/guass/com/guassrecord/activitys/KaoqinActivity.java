package www.guass.com.guassrecord.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import www.guass.com.guassrecord.R;
import www.guass.com.guassrecord.utils.DateUtils;

/**
 * Created by guass on 2017/12/17.
 */

public class KaoqinActivity extends SwipeBackActivity {

    private TextView mTextView_tongji;
    private TextView mTextView_week_day;
    private TextView mTextView_year;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaoqin);
        initView();
    }

    private void initView(){
        mTextView_tongji = findViewById(R.id.tv_tongji);

        mTextView_tongji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(KaoqinActivity.this, RecordActivity.class));
            }
        });

        mTextView_week_day = findViewById(R.id.tv_week_day);
        mTextView_year = findViewById(R.id.tv_year);

        mTextView_week_day.setText(DateUtils.getWeekOfDate());
        mTextView_year.setText(DateUtils.currentInFormat(DateUtils.FULL_YEAR));
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
