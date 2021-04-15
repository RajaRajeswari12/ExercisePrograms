package com.example.javabasic;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateEx {
	void localDateDisplay() {
		LocalDate ldValue = LocalDate.now();
		System.out.println(ldValue);
		LocalDate timeZoneSet = LocalDate.now(ZoneId.of("America/New_York"));
		System.out.println(timeZoneSet);
	}
	
	void localTimeDisplay() {
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		LocalTime ltZone = LocalTime.now(ZoneId.of("GMT"));
		System.out.println(ltZone);
		
	}
	
	Period dateDiff(LocalDate startDate,LocalDate endDate) {
		Period p = Period.between(startDate,  endDate);
		return p;
	}
	
	public static void main(String args[]) {
		Date d =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy/dd");
		String strDate = sdf.format(d);
		System.out.println(strDate);
		
		
		//LocalDate Example
		DateEx e = new DateEx();
		e.localDateDisplay();
		
		e.localTimeDisplay();
		LocalDate startDate = LocalDate.of(2019, 4, 13);
		LocalDate endDate = LocalDate.now();
	Period p=	e.dateDiff(startDate, endDate);
	
	System.out.println("Diff between years "+startDate+" and "+ endDate+" is "+p.getDays() + "days "+p.getMonths()+"months "+p.getYears()+"years ");
	}

}
