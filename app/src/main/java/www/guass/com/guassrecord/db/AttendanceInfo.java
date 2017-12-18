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

    @Column(name = "sign_in_time_year")
    private String sign_in_time_year;

    @Column(name = "sign_in_time_month")
    private String sign_in_time_month;

    @Column(name = "sign_in_time_day")
    private String sign_in_time_day;

    @Column(name = "sign_back_time")
    private String sign_back_time;

    @Column(name = "sign_back_time_year")
    private String sign_back_time_year;

    @Column(name = "sign_back_time_month")
    private String sign_back_time_month;

    @Column(name = "sign_back_time_day")
    private String sign_back_time_day;

    @Column(name = "late_time")
    private int late_time; // 迟到分钟

    @Column(name = "late_time")
    private int early_time;  //早到分钟
}
