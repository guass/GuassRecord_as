package www.guass.com.guassrecord.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import www.guass.com.guassrecord.R;
import www.guass.com.guassrecord.views.SwipeBackLayout;

/**
 * Created by guass on 2017/12/17.
 */

public class SwipeBackActivity extends AppCompatActivity {

    protected SwipeBackLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                R.layout.base, null);
        layout.attachToActivity(this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }

    @Override
    public void startActivity(Intent intent)
    {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
