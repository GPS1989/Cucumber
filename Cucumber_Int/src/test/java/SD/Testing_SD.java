package SD;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.assertj.core.api.SoftAssertions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Testing_SD {

	WebDriver driver = null;
	public static SoftAssertions softAsserstions;

	@Before
	public void intializationOfSoftAssertions() {
		softAsserstions = new SoftAssertions();

	}

	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step- Browser is open");
		String ProjectPath = System.getProperty("user.dir");
		System.out.println("Project path is mentioned" + ProjectPath);

		System.setProperty("webdriver.chrome.driver", ProjectPath + "//src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step- User is on google search page");
		driver.navigate().to("https://google.com");
	}

	@And("user enter text in search box")
	public void user_enter_text_in_search_box() {
		System.out.println("Inside Step- user enters text");
		driver.findElement(By.name("q")).sendKeys("Clarivate Analytics");
	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("Inside Step- user hits enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	@And("user is navigated to the search results")
	public void user_is_navigated_to_the_search_results() {
		System.out.println("Inside Step- user navigated to the search steps");
		driver.findElement(By.xpath("//a[@href='https://clarivate.com/']")).click();
		System.out.println("user has clicked link");

	}

	@And("Click on the Products and services")
	public void click_on_the_Products_and_services() {
		driver.findElement(By.xpath("//a[@class=\"nav-link\"][contains(.,'Products & Services')]")).click();
	}

	@And("Click on the Portfolio Strategy & Business Development")
	public void click_on_the_Portfolio_Strategy_Business_Development() {
		driver.findElement(By.xpath(
				"//a[@href='https://clarivate.com/products/biopharma/portfolio-strategy-business-development/'][contains(.,'Portfolio Strategy & Business Development')]"))
				.click();
	}

	@And("Click on the Generics Intelligence")
	public void click_on_the_Generics_Intelligence() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(
				"//a[@href='https://clarivate.com/cortellis/solutions/generics-intelligence-analytics/'][contains(.,'Cortellis Generics Intelligence')]"))
				.click();

	}

	@And("Click on the login menu")
	public void click_on_the_login_menu() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@class='cp-default-close']")).click();
		driver.findElement(By.xpath("//a[@href='https://clarivate.com/login/'][text()='Login ']")).click();

	}

	@And("Click on the Cortellis Generics Intelligence Login")
	public void Click_on_the_Cortellis_Generics_Intelligence_Login() {
		driver.findElement(
				By.xpath("//a[@href='http://cortellis.com/generics'][text()='Cortellis Generics Intelligence Login']"))
				.click();

	}

	@Then("Verify the URL")
	public void Verify_the_URL() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Total opened windows= " + allWindows.size());
		for (String actual : allWindows) {
			if (!actual.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(actual);
				String URL = driver.getCurrentUrl();
				System.out.println("URL is : " + URL);
				softAsserstions.assertThat(URL).contains("https://access.cortellis.com/login");
				softAsserstions.assertThat(URL).contains("app=generics");
				driver.close();
			}
		}
	
		driver.quit();
	}

	
}