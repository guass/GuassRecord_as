package www.guass.com.guassrecord.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
        RecordAdapter mHomeAdapter = new RecordAdapter(this);
        mRecyclerView.setAdapter(mHomeAdapter);




    }
}
