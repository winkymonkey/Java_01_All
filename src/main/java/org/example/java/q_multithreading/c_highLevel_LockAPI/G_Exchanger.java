package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.Exchanger;


class Test08 {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();

		Thread producer = new Thread(() -> {
			String producerStr = "A";
			try {
				String result = exchanger.exchange(producerStr);
				System.out.println("Producer send "+producerStr+" and received "+result);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		producer.start();
		
		Thread consumer = new Thread(() -> {
			String consumerStr = "B";
			try {
				String result = exchanger.exchange(consumerStr);
				System.out.println("Producer send "+consumerStr+" and received "+result);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		consumer.start();
	}
}

