package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageFactory.HomePage_PF;
import pageFactory.LoginPage_PF;

public class LoginDemoSteps_PF {
	WebDriver driver = null;
	LoginPage_PF login;
	HomePage_PF home;

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
		System.out.println("=== I am inside LoginDemoSteps_PF class ===");
		driver.get("https://example.testproject.io/web/");
	}

	@When("^user enters(.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		login=new LoginPage_PF(driver);
		login.enterUsername(username);
		login.enterPassword(password);
//		driver.findElement(By.id("name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("user clicks on login")
	public void user_clicks_on_login() {
		
		login.clickOnLogin();
		
//		driver.findElement(By.id("login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		home=new HomePage_PF(driver);
		home.checkLogoutIsDisplayed();
		//driver.findElement(By.id("logout")).isDisplayed();
		driver.quit();
	}
}
