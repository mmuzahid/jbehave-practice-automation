package practice.jbehave.steps;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Assert;

public class VisitWebSteps extends Steps {

	private static WebDriver driver;
	static {
		initChromeDriver();
	}

	private static void initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\practice\\jbehave\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("open a browser")
	public void openBrowser() {
		driver.manage().deleteAllCookies();
	}

	@When("visit $url")
	public void openUrl(String url) {
		driver.get(url);
	}

	@Then("page title is $title")
	public void assertTitle(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}

	@AfterStories
	public void cleanup() {
		driver.close();
	}

}
