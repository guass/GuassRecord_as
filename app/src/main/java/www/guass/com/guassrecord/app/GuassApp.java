package www.guass.com.guassrecord.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by guass on 2017/12/17.
 */

public class GuassApp extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        init();
    }

    private void init(){
        x.Ext.init(this);
        x.Ext.setDebug(false); // 是否输出debug日志, 开启debug会影响性能.
    }
}
