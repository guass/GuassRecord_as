package www.guass.com.guassrecord.db;

/**
 * Created by guass on 2018/1/1.
 */

public class AttendanceDBimpl {

    private static final String TAG = "guass";
    private static final AttendanceDBimpl ourInstance = new AttendanceDBimpl();

    public static AttendanceDBimpl getInstance()
    {
        return ourInstance;
    }

    private AttendanceDBimpl()
    {
    }
}
