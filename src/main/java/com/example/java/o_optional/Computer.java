package com.example.java.o_optional;


public class Computer {
	private Soundcard soundcard;
	public Soundcard getSoundcard() {
		return soundcard;
	}
	public void setSoundcard(Soundcard soundcard) {
		this.soundcard = soundcard;
	}
}

class Soundcard {
	private USB usb;
	public USB getUsb() {
		return usb;
	}
	public void setUsb(USB usb) {
		this.usb = usb;
	}
}

class USB {
	private String version;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
