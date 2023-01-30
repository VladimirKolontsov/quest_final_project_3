package ru.javarush.quest.kolontsov.entity;


import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistic {
    String login;
    String dateTime;
    Question lastQuestion;
    String result;

    public static String currentTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date1 = date;
        if (date1 == null) {
            date1 = new Date(System.currentTimeMillis());
        }
        return formatter.format(date1);
    }

    @Override
    public String toString() {
        return dateTime + "             " +result;
    }
}
