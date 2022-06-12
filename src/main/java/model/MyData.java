package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Comparator;

@Data
@AllArgsConstructor
public class MyData implements Comparable<MyData> {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private Long timeStamp;

    public MyData(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyData() {
        this.day = LocalDateTime.now().getDayOfMonth();
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
        this.hour = LocalDateTime.now().getHour();
        this.minute = LocalDateTime.now().getMinute();
        this.timeStamp = (System.currentTimeMillis() / 1000);
    }

    public static MyData emptyMyData() {
        MyData emptyData = new MyData();
        emptyData.day = 0;
        emptyData.month = 0;
        emptyData.year = 0;
        emptyData.hour = 0;
        emptyData.minute = 0;
        return emptyData;
    }

    public boolean isEmpty() {
        if (this.day == 0 && this.month == 0) {
            return true;
        } else {
            System.out.println("INVALID DATA");
            return false;
        }
    }

    public static Long minuteBetween(MyData stop, MyData start) {
        return stop.timeStamp - start.timeStamp;
    }


    @Override
    public int compareTo(MyData m){
        return Comparator.comparing(MyData::getYear)
                        .thenComparing(MyData::getMonth)
                                .thenComparing(MyData::getDay)
                                        .compare(this, m);

    }

}
