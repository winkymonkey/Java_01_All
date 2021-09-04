package org.example.java.o_optional;

import java.util.Optional;


public class C_optionalForNullCheck {
	
	public static void main(String[] args) {
		USB usb = new USB();
		usb.setVersion("version1");
		Soundcard soundcard = new Soundcard();
		soundcard.setUsb(usb);
		Computer computer = new Computer();
		computer.setSoundcard(soundcard);
		
		// adding null check
		safeWay_traditional(computer);
		safeWay_traditional(new Computer());
		
		// adding null check
		safeWay_modern(computer);
		safeWay_modern(new Computer());
	}
	
	
	
	private static void safeWay_traditional(Computer computer) {
		String version = "old version";
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
	
	
	
	private static void safeWay_modern(Computer computer) {
		Optional<String> opt = Optional.of(computer).map(Computer::getSoundcard).map(Soundcard::getUsb).map(USB::getVersion);
		System.out.println(opt.isPresent() ? opt.get() : "old version");
	}
	
}
