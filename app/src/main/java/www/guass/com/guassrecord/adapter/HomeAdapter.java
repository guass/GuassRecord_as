package www.guass.com.guassrecord.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import www.guass.com.guassrecord.R;

/**
 * Created by guass on 2017/12/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener {

    private static final String TAG = "guass";
    private Context mContext;

    private OnItemClickListener mOnItemClickListener = null;

    public HomeAdapter(Context context) {
        mContext=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_app,null);
        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.mImageView.setBackgroundResource(R.drawable.ic_kaoqin_red_24dp);
        holder.mTextView.setText("kaoqin");

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount()
    {
        return 1;
    }

    @Override
    public void onClick(View v)
    {
        Log.i(TAG, "onClick: ");
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
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

    public  interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
