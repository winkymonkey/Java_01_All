package org.example.java.q_multithreading.a_lowLevel;


class Counter1 {
	protected long count = 0;

	public void add(long value) {
		this.count = this.count + value;
	}
}
