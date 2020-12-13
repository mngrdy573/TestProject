package StepDefinitions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GoogleSearchSteps {
	WebDriver driver=null;
	@Given("browser is open")
	public void browser_is_open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.google.co.in/");
	}
	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("Automation Step by Step");
	}
	@And("hits enter")
	public void hits_enter() {
		driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
	}
	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		driver.getPageSource().contains("Online Courses");
		driver.quit();
	}
}
