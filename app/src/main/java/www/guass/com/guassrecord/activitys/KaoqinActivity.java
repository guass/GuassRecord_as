package www.guass.com.guassrecord.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import www.guass.com.guassrecord.R;
import www.guass.com.guassrecord.db.AttendanceDBimpl;
import www.guass.com.guassrecord.utils.DateUtils;

/**
 * Created by guass on 2017/12/17.
 */

public class KaoqinActivity extends SwipeBackActivity {

    private TextView mTextView_tongji;
    private TextView mTextView_week_day;
    private TextView mTextView_year;

    private Button mButton_go_work_sign;
    private Button mButton_after_work_sign;

    private AttendanceDBimpl mAttendanceDBimpl = AttendanceDBimpl.getInstance();

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
        mTextView_year.setText(DateUtils.currentInFormat(DateUtils.FULL_YEAR_2_1));

        mButton_go_work_sign = findViewById(R.id.btn_go_work);
        mButton_after_work_sign = findViewById(R.id.btn_after_work);

        mButton_go_work_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goWorkSign();
            }
        });

        mButton_after_work_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                afterWorkSign();
            }
        });
    }

    private void goWorkSign(){
        boolean isOK = mAttendanceDBimpl.updateWorkRecord_in();
        if(isOK){
            Toast.makeText(this,"sign suceess!!",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"today is already sign!!",Toast.LENGTH_LONG).show();
        }
    }

    private void afterWorkSign(){
        boolean isOK = mAttendanceDBimpl.updateWorkRecord_out();
        if(isOK){
            Toast.makeText(this,"sign suceess!!",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"today no go work sign!!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
