package cc.openhome;

import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;

public class Exercise1 {
    public static void main(String[] args) {
        // 今天
        Calendar calendar = Calendar.getInstance();
        System.out.printf("%n[%s]%n%n", calendar.getDisplayName(MONTH, LONG, Locale.TAIWAN));
        String[] week = {"日", "一", "二", "三", "四", "五", "六"};
        for(String weekDay : week) {
            System.out.printf("%s ", weekDay);
        }
        System.out.println();
        // 今天是本月第幾天
        int dayOfMonth = calendar.get(DAY_OF_MONTH);
        // 取得本月第一天
        calendar.add(DAY_OF_MONTH, -dayOfMonth + 1);
        // 本月第一天是星期的第幾天
        int dayOfWeek = calendar.get(DAY_OF_WEEK);
        System.out.printf("%" + (2 * (dayOfWeek + 1)) + "s", "");
        // 本月有幾天
        int maxDayOfMonth = calendar.getMaximum(DAY_OF_MONTH);
        for(int i = 1; i <= maxDayOfMonth; i++, dayOfWeek++) {
            if(i == dayOfMonth - 1) {
                System.out.printf("%2d", i);
            }
            else if(i == dayOfMonth) {
                System.out.printf("[%2d]", i);
            } else {
                System.out.printf("%2d ", i);
            }
            
            if((dayOfWeek % 7) == 0) {
                System.out.println();
            }
        }
    }
}
