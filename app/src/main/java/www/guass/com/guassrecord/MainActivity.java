package www.guass.com.guassrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import www.guass.com.guassrecord.activitys.KaoqinActivity;
import www.guass.com.guassrecord.activitys.RecordActivity;
import www.guass.com.guassrecord.adapter.HomeAdapter;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    private static final String TAG = "guass";
    static
    {
        System.loadLibrary("native-lib");
    }

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
    }


    private HomeAdapter mHomeAdapter;
    private void initView(){
      mRecyclerView = findViewById(R.id.rv_main);

        Log.i(TAG, "initView: " + mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHomeAdapter = new HomeAdapter(this);
        mRecyclerView.setAdapter(mHomeAdapter);

        mHomeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position)
            {
                startOtherActivity();
            }
        });


    }

    private void startOtherActivity(){
        startActivity(new Intent(this, KaoqinActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
