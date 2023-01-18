package org.ssglobal.training.codes.itemA;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalendar {
	public void printCalendar(int month, int year) {
		Calendar cal = new GregorianCalendar(year, month - 1, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
		String monthYear = sdf.format(cal.getTime());
		System.out.println("%16s".formatted(monthYear));
		System.out.println("Su Mo Tu We Th Fr Sa");
		
		int firstDayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
		for (int i = 1; i < firstDayOfMonth; i++) {
            System.out.print("   ");
        }
		
		while (cal.get(Calendar.MONTH) == month - 1) {
            int day = cal.get(Calendar.DATE);
            System.out.print("%2d ".formatted(day));

            if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.println();
            }

            cal.add(Calendar.DATE, 1);
        }
	}
}
