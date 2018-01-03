package www.guass.com.guassrecord.activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import www.guass.com.guassrecord.R;
import www.guass.com.guassrecord.adapter.RecordAdapter;

/**
 * Created by guass on 2017/12/17.
 */

public class RecordActivity extends SwipeBackActivity {

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
            public void onItemClick(View view, int position) {

            }
        });

    }

    private void  showItemDetail(){
        View contentView = LayoutInflater.from(this).inflate(0, null);

        AlertDialog dialog_pop_alert= new AlertDialog.Builder(this).create();
        dialog_pop_alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

            }
        });

        dialog_pop_alert.setCancelable(false);
        dialog_pop_alert.setCanceledOnTouchOutside(false);
        Window window = dialog_pop_alert.getWindow();
        window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog_pop_alert.show();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(Gravity.CENTER);
        window.setContentView(contentView);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = 800;
        lp.height = 600;
        window.setAttributes(lp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
