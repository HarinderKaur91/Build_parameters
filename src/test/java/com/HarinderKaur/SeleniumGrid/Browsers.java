package com.HarinderKaur.SeleniumGrid;

public enum Browsers {
	CHROME("chrome"),
	EDGE("edge"),
	FIREFOX("firefox");
	
	String browserName;
	
	private Browsers(String name) {
		this.browserName = name;
	}
	
	public String getName() {
		return browserName;
	}
}
