package com.example.java.a_coreStructure.enums.enum4;


public enum Color {
	RED, GREEN(), BLUE(100), 
	YELLOW() {
		@Override
		public String getStr() {
			return "Color Yellow";
		}
	}, 
	VIOLET(200) {
		@Override
		public String getStr() {
			return "Color Violet";
		}
	}, 
	MAROON(300) {
		public void special() {
			System.out.println("printing");
		}
	};
	
	Color() {
		System.out.println("default constructor");
	}
	Color(int x) {
		this.code = x;
		System.out.println("1-param constructor");
	}
	
	private int code;
	private String str;
	public int getCode() {
		return code;
	}
	public String getStr() {
		return str;
	}
}

