package com.automation.assessment.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.assessment.constants.Browser;
import com.automation.assessment.exception.AssessmentException;

import io.cucumber.java.Before;

public class ApplicationHooks {

	private Properties properties;
	private static WebDriver driver;
	private static final String PROPERTY_FILE_PATH = "src\\test\\resources\\properties\\qa-environment.properties";

	@Before(order = 0)
	public void loadPropertyFiles() {
		properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(PROPERTY_FILE_PATH));
			properties.load(fis);
		} catch (FileNotFoundException e1) {
			throw new AssessmentException("Invalid property file path is given: Given path is " + PROPERTY_FILE_PATH);
		} catch (IOException e) {
			throw new AssessmentException("IOException is caught while reading property file");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				throw new AssessmentException("IOException is caught while reading property file");
			}
		}

	}

	@Before(order = 1)
	public void initializeDriver() {
		String browser = properties.getProperty("browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser type is given");
		}

	}

	public Properties getProperties() {
		return properties;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
