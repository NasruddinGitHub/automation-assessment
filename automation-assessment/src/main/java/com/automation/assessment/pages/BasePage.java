package com.automation.assessment.pages;

import java.time.Duration;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.picocontainer.classname.ClassName;

import com.automation.assessment.constants.Browser;
import com.automation.assessment.exception.AssessmentException;
import com.automation.assessment.hooks.ApplicationHooks;

public class BasePage {

	protected WebDriver driver = ApplicationHooks.getDriver();;
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement findElement(By locator, int timeout) {
		int attempts = 0;
		WebElement element = null;
		while (attempts < 10) {
			try {
				waitUntilElementIsVisible(locator, timeout);
				element = driver.findElement(locator);
				break;
			} catch (StaleElementReferenceException e) {
				LOGGER.info("StaleElementReferenceException is thrown, hence retrying");
				if (attempts == 9) {
					throw new AssessmentException("StaleElementReferenceException is thrown. Retried for 10 times");
				}
			}
			attempts++;
		}
		return element;
	}

	public void waitUntilElementIsVisible(By locator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new AssessmentException("Element is not visible within the stipulated time");
		}
	}

	public void waitUntilElementIsVisible(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new AssessmentException("Element is not visible within the stipulated time");
		}
	}

	public void waitUntilElementIsClickable(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new AssessmentException("Element is not clicked within the stipulated time");
		}
	}

	public void waitUntilElementIsVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new AssessmentException("Element is not visible within the stipulated time");
		}
	}

	public void waitUntilElementIsClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new AssessmentException("Element is not clicked within the stipulated time");
		}
	}

	public void click(WebElement element, int timeout) {
		int attempts = 0;
		while (attempts < 10) {
			try {
				waitUntilElementIsVisible(element, timeout);
				waitUntilElementIsClickable(element, timeout);
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
				LOGGER.info("StaleElementReferenceException is thrown, hence retrying");
				if (attempts == 9) {
					throw new AssessmentException("StaleElementReferenceException is thrown. Retried for 10 times");
				}
			} catch (InvalidElementStateException e) {
				LOGGER.info("InvalidElementStateException is thrown, hence retrying");
				if (attempts == 9) {
					throw new AssessmentException("InvalidElementStateException is thrown. Retried for 10 times");
				}
			}
			attempts++;
		}
	}

	public void click(WebElement element) {
		int attempts = 0;
		while (attempts < 10) {
			try {
				waitUntilElementIsVisible(element);
				waitUntilElementIsClickable(element);
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
				LOGGER.info("StaleElementReferenceException is thrown, hence retrying");
				if (attempts == 9) {
					throw new AssessmentException("StaleElementReferenceException is thrown. Retried for 10 times");
				}
			} catch (InvalidElementStateException e) {
				LOGGER.info("InvalidElementStateException is thrown, hence retrying");
				if (attempts == 9) {
					throw new AssessmentException("InvalidElementStateException is thrown. Retried for 10 times");
				}
			}
			attempts++;
		}
	}

	public String getText(WebElement element, int timeout) {
		int attempts = 0;
		String text = "";
		while (attempts < 10) {
			try {
				waitUntilElementIsVisible(element, timeout);
				text = element.getText().trim();
				break;
			} catch (StaleElementReferenceException e) {
				LOGGER.info("StaleElementReferenceException is thrown, hence retrying");
				if (attempts == 9) {
					throw new AssessmentException("StaleElementReferenceException is thrown. Retried for 10 times");
				}
			}
			attempts++;
		}
		return text;
	}

	public void switchToWindowUsingContainsUrl(String partialUrl) {

		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			String url= driver.getCurrentUrl();
			if (driver.getCurrentUrl().contains(partialUrl)) {
				driver.switchTo().window(window);
				break;
			}
		}

	}

}
