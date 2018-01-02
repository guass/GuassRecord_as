package www.guass.com.guassrecord.db;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

import www.guass.com.guassrecord.utils.DateUtils;

/**
 * Created by guass on 2018/1/1.
 */

public class AttendanceDBimpl {

    private static final String TAG = "AttendanceDBimpl";


    private static final String DB_NAME = "work_record_db";
    private static DbManager db;
    private static final AttendanceDBimpl ourInstance = new AttendanceDBimpl();

    public static AttendanceDBimpl getInstance()
    {
        return ourInstance;
    }

    private AttendanceDBimpl() {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig().setDbName(DB_NAME).setDbVersion(1);
        db = x.getDb(daoConfig);
    }

    private void add(AttendanceInfo attendanceInfo){
        try {
            db.save(attendanceInfo);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll(){
        try {
            db.delete(AttendanceInfo.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public boolean updateWorkRecord_in(){
        String record_date = DateUtils.currentInFormat(DateUtils.FULL_YEAR);
        String record_date_min = DateUtils.currentInFormat(DateUtils.PATTERN_HOUR_MINUTE);
        List<AttendanceInfo> info = findInTimeByDate( DateUtils.currentInFormat(DateUtils.FULL_YEAR));
        if(info== null || info.size() == 0){
            AttendanceInfo info_new = new AttendanceInfo();
            info_new.setSign_in_time(record_date_min);
            info_new.setSign_in_time_date(record_date);

            int diff = DateUtils.getIntervalTimeReal(record_date_min,"9:00",DateUtils.PATTERN_HOUR_MINUTE);
            if(diff > 0){
                info_new.setEarly_time(diff);
            }
            else {
                info_new.setLate_time(Math.abs(diff));
            }
            add(info_new);
            return true;
        }
        return false;
    }

    public void updateWorkRecord_out(){
        String record_date = DateUtils.currentInFormat(DateUtils.FULL_YEAR);
        String record_date_min = DateUtils.currentInFormat(DateUtils.PATTERN_HOUR_MINUTE);
        List<AttendanceInfo> info = findInTimeByDate( DateUtils.currentInFormat(DateUtils.FULL_YEAR));
        if(info != null && info.size() == 1){
                AttendanceInfo info_update = info.get(0);
                info_update.setSign_back_time_date(record_date);
                info_update.setSign_back_time(record_date_min);
                int diff = DateUtils.getIntervalTimeReal(record_date_min,"18:00",DateUtils.PATTERN_HOUR_MINUTE);
                if(diff > 0){
                    info_update.setLeave_early_time(diff);
                }
                else {
                    info_update.setOver_work_time(Math.abs(diff));
                }
        }
    }

    private List<AttendanceInfo> findInTimeByDate(String date){
        try {
            return db.selector(AttendanceInfo.class)
                    .where(WhereBuilder.b("sign_in_time_date", "=", date))
                    .findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }

        return null;
    }
}
