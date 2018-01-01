package www.guass.com.guassrecord.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import www.guass.com.guassrecord.R;

/**
 * Created by guass on 2018/1/1.
 */

public class RecordAdapter  extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {


    private Context mContext;
    public RecordAdapter(Context context){
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_record,null);
        RecordAdapter.MyViewHolder holder = new RecordAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView mImageView;
        TextView mTextView;

        public MyViewHolder(View view)
        {
            super(view);
            mImageView = view.findViewById(R.id.iv_app);
            mTextView = view.findViewById(R.id.tv_app);
        }
    }
}
