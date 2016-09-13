package com.test.controller;

import java.util.Calendar;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		System.out.println(Demo.getTimesMorning());
		System.out.println(Demo.getTimesCurrent());
		
		String s = "select calcTime, orderCount, totalAmount, round(totalAmount/ordercount, 2) as singlePrice " +  
					"from (select calc_time as calcTime, CAST(sum(order_count) as signed) as orderCount, sum(order_total_amount) as totalAmount from channel_order " +  
					"where calc_time >= ? and calc_time < ? and calc_interval = 60 and order_platform = ?) t";
		
		System.out.println(s);
		
		System.out.println(new Date(1472634000000L));
		
	}
	
	public static int getTimesMorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}
	
	public static long getTimesCurrent() {
		return System.currentTimeMillis() / 1000;
	}
	
	
}
