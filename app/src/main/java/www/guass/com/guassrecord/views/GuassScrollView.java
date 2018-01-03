package www.guass.com.guassrecord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ScrollView;



/**
 * Created by GUASS_ZJG on 2018/1/3 0003.
 * Email:guasszig@gmail.com
 */

public class GuassScrollView extends ScrollView {

    // 这个值控制可以把ScrollView包裹的控件拉出偏离顶部或底部的距离。
    private static final int MAX_OVERSCROLL_Y = 200;

    private Context mContext;
    private int newMaxOverScrollY;


    public GuassScrollView(Context context) {
        this(context,null);
    }

    public GuassScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GuassScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context){
        this.mContext = context;

        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        float density = metrics.density;
        newMaxOverScrollY = (int) (density * MAX_OVERSCROLL_Y);

        //false:隐藏ScrollView的滚动条。
        this.setVerticalScrollBarEnabled(false);

        //不管装载的控件填充的数据是否满屏，都允许橡皮筋一样的弹性回弹。
        this.setOverScrollMode(ScrollView.OVER_SCROLL_ALWAYS);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
                scrollRangeX, scrollRangeY, maxOverScrollX, newMaxOverScrollY,
                isTouchEvent);
    }
}
