package dev.estillero.runners;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.estillero.pages.OptionsPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.estillero.steps")
public class TestRunner {
	
	public static WebDriver driver;
	public static OptionsPage optionspage;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		driver = new FirefoxDriver();
		optionspage = new OptionsPage(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
