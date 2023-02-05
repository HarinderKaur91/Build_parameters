package com.HarinderKaur.SeleniumGrid;

import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.naveenautomation.Browsers.ProxyDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGridTest {
	SoftAssert softAssert;

	// ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver driver;
	public Browsers browser;

	@BeforeMethod()
	public void setUp() {

		// It helps to launch our application in the desired environment having the
		// capabilities that we desire to use.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);

		// The Chrome options class is generally used in conjunction with Desired
		// Capabilities for customizing Chrome driver sessions
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		options.addArguments("--disable-popup-blocking");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("start-maximized");

		// options.merge(capabilities);

		HashMap<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("download.default_directory", System.getProperty("user.dir"));
		String browserName = System.getProperty("browser");
		if (browserName != null) {
			browser = Browsers.valueOf(browserName.toUpperCase());
		} else {
			browser = Browsers.GOOGLE_CHROME;
		}
		switch (browser) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", preferences);
			driver = new ChromeDriver(options);
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}

		// WebDriverManager.chromedriver().setup();
		softAssert = new SoftAssert();

//		try {
//			driver.set(new RemoteWebDriver(new URL("http://192.168.1.78:4444"), capabilities));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test
	public void testCase1() {
		driver.get("https://www.selenium.dev/documentation/grid/getting_started/");
		System.out.println(driver.getTitle());
	}

//	@Test
//	public void testCase2() {
//		driver.get().get("https://www.guru99.com/introduction-to-selenium-grid.html");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase3() {
//		driver.get().get("https://www.lambdatest.com/blog/selenium-grid-setup-tutorial/");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase4() {
//		driver.get().get("https://www.javatpoint.com/selenium-grid");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase5() {
//		driver.get().get("https://www.browserstack.com/guide/parallel-testing-with-selenium");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase6() {
//		driver.get().get("https://github.com/SeleniumHQ/docker-selenium");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase7() {
//		driver.get().get("https://www.tutorialspoint.com/selenium/selenium_grids.htm");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase8() {
//		driver.get().get("https://www.toolsqa.com/selenium-webdriver/selenium-grid/");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase9() {
//		driver.get().get("https://www.geeksforgeeks.org/selenium-basics-components-features-uses-and-limitations/");
//		System.out.println(driver.get().getTitle());
//	}
//
//	@Test
//	public void testCase10() {
//		driver.get().get("https://www.javacodegeeks.com/selenium-tutorials");
//		System.out.println(driver.get().getTitle());
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}