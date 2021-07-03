package com.example.java.q_multithreading.a_lowLevel;


public class H_ThreadSafety_Volatile {
	private int years;
	private int months;
	private volatile int days;

	public int totalDays() {
		int total = this.days;		//reading a volatile variable should be at start
		total += months * 30;
		total += years * 365;
		return total;
	}

	public void update(int years, int months, int days) {
		this.years = years;
		this.months = months;
		this.days = days;			//writing to a volatile variable should be at end
	}
}

