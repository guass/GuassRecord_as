package www.guass.com.guassrecord.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by GUASS_ZJG on 2017/12/18 0018.
 * Email:guasszig@gmail.com
 */

@Table(name = "AttendanceInfo")
public class AttendanceInfo {

    @Column(name = "id" ,isId = true)
    private int id;

    @Column(name = "sign_in_time")
    private String sign_in_time;

    @Column(name = "sign_in_time_date")
    private String sign_in_time_date;



    @Column(name = "sign_back_time")
    private String sign_back_time;


    @Column(name = "sign_back_time_date")
    private String sign_back_time_date;


    @Column(name = "late_time")
    private int late_time; // 迟到分钟

    @Column(name = "early_time")
    private int early_time;  //早到分钟

    @Column(name = "over_work_time")
    private int over_work_time;  //加班分钟

    @Column(name = "leave_early_time")
    private int leave_early_time;  //加班分钟

    @Column(name = "week_day")
    private String week_day;


    public String getSign_in_time() {
        return sign_in_time;
    }

    public void setSign_in_time(String sign_in_time) {
        this.sign_in_time = sign_in_time;
    }

    public String getSign_in_time_date() {
        return sign_in_time_date;
    }

    public void setSign_in_time_date(String sign_in_time_date) {
        this.sign_in_time_date = sign_in_time_date;
    }

    public String getSign_back_time() {
        return sign_back_time;
    }

    public void setSign_back_time(String sign_back_time) {
        this.sign_back_time = sign_back_time;
    }

    public String getSign_back_time_date() {
        return sign_back_time_date;
    }

    public void setSign_back_time_date(String sign_back_time_date) {
        this.sign_back_time_date = sign_back_time_date;
    }

    public int getLate_time() {
        return late_time;
    }

    public void setLate_time(int late_time) {
        this.late_time = late_time;
    }

    public int getEarly_time() {
        return early_time;
    }

    public void setEarly_time(int early_time) {
        this.early_time = early_time;
    }

    public int getOver_work_time() {
        return over_work_time;
    }

    public void setOver_work_time(int over_work_time) {
        this.over_work_time = over_work_time;
    }

    public int getLeave_early_time() {
        return leave_early_time;
    }

    public void setLeave_early_time(int leave_early_time) {
        this.leave_early_time = leave_early_time;
    }

    public String getWeek_day()
    {
        return week_day;
    }

    public void setWeek_day(String week_day)
    {
        this.week_day = week_day;
    }

    @Override
    public String toString()
    {
        return "AttendanceInfo{" +
                "id=" + id +
                ", sign_in_time='" + sign_in_time + '\'' +
                ", sign_in_time_date='" + sign_in_time_date + '\'' +
                ", sign_back_time='" + sign_back_time + '\'' +
                ", sign_back_time_date='" + sign_back_time_date + '\'' +
                ", late_time=" + late_time +
                ", early_time=" + early_time +
                ", over_work_time=" + over_work_time +
                ", leave_early_time=" + leave_early_time +
                ", week_day='" + week_day + '\'' +
                '}';
    }
}
