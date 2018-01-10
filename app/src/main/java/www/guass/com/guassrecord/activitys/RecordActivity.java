package www.guass.com.guassrecord.activitys;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import www.guass.com.guassrecord.R;
import www.guass.com.guassrecord.adapter.RecordAdapter;
import www.guass.com.guassrecord.base.BaseActivity;
import www.guass.com.guassrecord.db.AttendanceInfo;

/**
 * Created by guass on 2017/12/17.
 */

public class RecordActivity extends BaseActivity {

    private static final String TAG = "RecordActivity";
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        mRecyclerView = findViewById(R.id.rv_record);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecordAdapter recordAdapter = new RecordAdapter(this);
        mRecyclerView.setAdapter(recordAdapter);


        recordAdapter.setOnItemClickListener(new RecordAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, AttendanceInfo info) {
                showItemDetail(info);
            }
        });

    }

    private void  showItemDetail(AttendanceInfo info){
        View view = LayoutInflater.from(this).inflate(R.layout.detail_record, null);

        TextView tv_record_date_value = view.findViewById(R.id.tv_record_date_value);
        TextView tv_go_work_record_time_value = view.findViewById(R.id.tv_go_work_record_time_value);
        TextView tv_after_work_sign_time_value = view.findViewById(R.id.tv_after_work_sign_time_value);
        TextView tv_late_time_value = view.findViewById(R.id.tv_late_time_value);
        TextView tv_over_work_time_value = view.findViewById(R.id.tv_over_work_time_value);

        tv_record_date_value.setText(info.getSign_in_time_date() + " " + info.getWeek_day());
        tv_go_work_record_time_value.setText(info.getSign_in_time());
        tv_after_work_sign_time_value.setText(info.getSign_back_time());
        tv_late_time_value.setText(info.getLate_time() + "m");
        tv_over_work_time_value.setText(info.getOver_work_time() + "m");

        final Dialog dialog = new Dialog(this);

        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        dialog.setCancelable(true);

        dialog.show();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int displayWidth = dm.widthPixels;
        int displayHeight = dm.heightPixels;
        android.view.WindowManager.LayoutParams p = dialog.getWindow().getAttributes();  //获取对话框当前的参数值
        p.width = (int) (displayWidth * 0.9);    //宽度设置为屏幕的0.5
        p.height = (int) (displayHeight * 0.48);    //宽度设置为屏幕的0.5
        dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        dialog.getWindow().setAttributes(p);     //设置生效
        dialog.setCanceledOnTouchOutside(true); //show 之后调用
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
