package www.guass.com.guassrecord.utils;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by GUASS_ZJG on 2018/1/3 0003.
 * Email:guasszig@gmail.com
 */

public class VibrateHelp {

    private static Vibrator vibrator;

    /**
     * 简单震动
     * @param context     调用震动的Context
     * @param millisecond 震动的时间，毫秒
     */
    @SuppressWarnings("static-access")
    public static void vSimple(Context context, int millisecond) {
        vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        if(vibrator != null)vibrator.vibrate(millisecond);
    }

    /**
     * 复杂的震动
     * @param context 调用震动的Context
     * @param pattern 震动形式
     * @param repeate 震动的次数，-1不重复，非-1为从pattern的指定下标开始重复
     */
    @SuppressWarnings("static-access")
    public static void vComplicated(Context context, long[] pattern, int repeate) {
        vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        if(vibrator != null)vibrator.vibrate(pattern, repeate);
    }

    /**
     * 停止震动
     */
    public static void stop() {
        if (vibrator != null) {
            vibrator.cancel();
        }
    }
}
