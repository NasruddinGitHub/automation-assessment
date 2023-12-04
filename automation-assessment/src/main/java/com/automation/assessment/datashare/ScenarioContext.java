package com.automation.assessment.datashare;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private Map<String, String> scenarioContext;
	
	public ScenarioContext() {
		scenarioContext = new HashMap<String, String>();
	}

	public void setContext(String key, String value) {
		scenarioContext.put(key, value);
	}

	public String getContext(String key) {
		return scenarioContext.get(key);
	}

}
