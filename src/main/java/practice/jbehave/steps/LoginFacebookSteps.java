package practice.jbehave.steps;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ByIdOrName;

public class LoginFacebookSteps extends Steps {

	private WebDriver driver;

	@BeforeStories
	public void initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\practice\\jbehave\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("open new winidow")
	public void openBrowser() {
		driver.manage().deleteAllCookies();
	}

	@When("goto $url")
	public void openUrl(String url) {
		driver.get(url);
	}
	
	@When("fill $email and $pass field")
	public void fillLoginForm(String email, String pass) {
		driver.findElement(new ByIdOrName(email)).sendKeys("muzahid");
		driver.findElement(new ByIdOrName(pass)).sendKeys("this_is_my_dummy_password");
	}

	@When("submit $loginForm")
	public void submitForm(String formNameOrId) {
		driver.findElement(new ByIdOrName(formNameOrId)).submit();
	}

	@Then("$title is page title")
	public void assertTitle(String title) {
		driver.getTitle();
		Assert.assertEquals(title, driver.getTitle());
	}

	@AfterStories
	public void cleanup() {
		driver.close();
	}

}
