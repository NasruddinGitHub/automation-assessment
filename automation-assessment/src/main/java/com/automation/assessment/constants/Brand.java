package com.automation.assessment.constants;

public enum Brand {
	POLICE_883("883 Police"), ADH("ADH"), ADIDAS("ADIDAS"), ALL_SAINTS("All Saints");

	private String value;

	private Brand(String value) {
		this.value = value;
	}

	public String getBrandValue() {
		return value;
	}
}
