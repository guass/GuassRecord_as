package www.guass.com.guassrecord.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.guass.com.guassrecord.R;
import www.guass.com.guassrecord.db.AttendanceDBimpl;
import www.guass.com.guassrecord.db.AttendanceInfo;

/**
 * Created by guass on 2018/1/1.
 */

public class RecordAdapter  extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {


    private static final String TAG = "RecordAdapter";
    private Context mContext;
    private List<AttendanceInfo> mAttendanceInfoList;
    private AttendanceDBimpl mAttendanceDBimpl = AttendanceDBimpl.getInstance();

    private List<Drawable> mDrawableList = new ArrayList<>();

    public RecordAdapter(Context context){
        mContext = context;
        mDrawableList.add(mContext.getResources().getDrawable(R.drawable.ic_touxiang_green_24dp));
        mDrawableList.add(mContext.getResources().getDrawable(R.drawable.ic_touxiang_black_24dp));
        mDrawableList.add(mContext.getResources().getDrawable(R.drawable.ic_touxiang_red_24dp));
        mDrawableList.add(mContext.getResources().getDrawable(R.drawable.ic_touxiang_yellow_24dp));
        initList();
    }

    private void initList(){
        mAttendanceInfoList = mAttendanceDBimpl.findAll();
        Log.i(TAG, "initList: " + mAttendanceInfoList);
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
        if(mAttendanceInfoList != null && mAttendanceInfoList.size() > 0){
            String week_day = mAttendanceInfoList.get(position).getWeek_day();
            String in_time_date = mAttendanceInfoList.get(position).getSign_in_time_date();
            String go_work_time = mAttendanceInfoList.get(position).getSign_in_time();
            String after_work_time = mAttendanceInfoList.get(position).getSign_back_time();

            int late_time = mAttendanceInfoList.get(position).getLate_time();
            int leave_early_time = mAttendanceInfoList.get(position).getLeave_early_time();

            Log.i(TAG, "onBindViewHolder: " + late_time);

            holder.mTextView_week_day.setText(week_day);
            holder.mTextView_year_date.setText(in_time_date);
            if(!TextUtils.isEmpty(go_work_time)){
                if(late_time > 5) holder.mTextView_work_in_time.setTextColor(Color.RED);
                holder.mTextView_work_in_time.setText(go_work_time);
            }
            if(!TextUtils.isEmpty(after_work_time)){
                if(leave_early_time > 0)  holder.mTextView_work_after_time.setTextColor(Color.RED);
                holder.mTextView_work_after_time.setText(after_work_time);
            }

            holder.mImageView_icon.setBackground(mDrawableList.get(position % mDrawableList.size()));

        }
    }

    @Override
    public int getItemCount()
    {
        if(mAttendanceInfoList != null)
        {
            return mAttendanceInfoList.size();
        }
        return 0;
    }

    public void clearAll() {
        if(mAttendanceInfoList != null){
            mAttendanceInfoList.clear();
            notifyDataSetChanged();
        }
    }

    public void addItem(AttendanceInfo info) {
        if(info != null) {
            mAttendanceInfoList.add(info);
            notifyItemInserted(mAttendanceInfoList.size()); //Attention!
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView mTextView_week_day;
        TextView mTextView_year_date;
        TextView mTextView_work_in_time;
        TextView mTextView_work_after_time;

        ImageView mImageView_icon;

        private MyViewHolder(View view)
        {
            super(view);
            mTextView_week_day = view.findViewById(R.id.tv_week_day);
            mTextView_year_date = view.findViewById(R.id.tv_year_date);
            mTextView_work_in_time = view.findViewById(R.id.tv_go_work_time);
            mTextView_work_after_time = view.findViewById(R.id.tv_after_time);

            mImageView_icon = view.findViewById(R.id.iv_touxiang);

        }
    }
}
