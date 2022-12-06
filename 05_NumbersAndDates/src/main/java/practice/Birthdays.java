package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        StringBuilder builder = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat(" - dd.MM.yyyy - EE", Locale.ENGLISH);
        Calendar calendar = new GregorianCalendar(year, month - 1, day, 0, 0, 0);
        Calendar today = Calendar.getInstance();
        int number = 0;
        while (calendar.before(today)) {
            builder.append(number).append(format.format(calendar.getTime())).append("\n");
            calendar.add(Calendar.YEAR, 1);
            number++;
        }
        return builder.toString();
    }
}