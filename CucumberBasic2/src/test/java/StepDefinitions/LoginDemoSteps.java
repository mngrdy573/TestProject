package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginDemoSteps {
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("The project path is:" + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers1/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.get("https://example.testproject.io/web/");
	}

	@When("^user enters(.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("user clicks on login")
	public void user_clicks_on_login() {
		driver.findElement(By.id("login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		driver.findElement(By.id("logout")).isDisplayed();
		driver.quit();
	}
}
