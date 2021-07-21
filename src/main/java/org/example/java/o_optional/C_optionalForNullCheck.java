package org.example.java.o_optional;

import java.util.Optional;
import java.util.function.Supplier;


public class C_optionalForNullCheck {
	
	public static void main(String[] args) {
		USB usb = new USB();
		usb.setVersion("v1");
		Soundcard soundcard = new Soundcard();
		soundcard.setUsb(usb);
		Computer computer = new Computer();
		computer.setSoundcard(soundcard);
		
		// without null check
		traditionalWay_Risky(computer);
		
		// adding null check
		traditionalWay_Safe(computer);
		
		// adding null check
		modernWay_Safe1(computer);
		modernWay_Safe2(computer);
	}
	
	
	
	private static void traditionalWay_Risky(Computer computer) {
		System.out.println(computer.getSoundcard().getUsb().getVersion());
	}
	
	
	private static void traditionalWay_Safe(Computer computer) {
		String version = "";
		if (computer != null) {
			Soundcard soundcard = computer.getSoundcard();
			if (soundcard != null) {
				USB usb = soundcard.getUsb();
				if (usb != null) {
					version = usb.getVersion();
				}
			}
		}
		System.out.println(version);
	}
	
	
	private static void modernWay_Safe1(Computer computer) {
		Optional.of(computer).map(Computer::getSoundcard).map(Soundcard::getUsb).map(USB::getVersion).ifPresent(System.out::println);
	}
	
	
	// traditional way -- adding null check
	private static void modernWay_Safe2(Computer computer) {
		resolve( () -> computer.getSoundcard().getUsb().getVersion() ).ifPresent(System.out::println);
	}
	private static <T> Optional<T> resolve(Supplier<T> supplier) {
	    try {
	        T result = supplier.get();
	        return Optional.ofNullable(result);
	    }
	    catch (NullPointerException e) {
	        return Optional.empty();
	    }
	}
	
}
