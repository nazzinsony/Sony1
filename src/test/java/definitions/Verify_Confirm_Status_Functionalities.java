package definitions;

import base.Base;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Confirm_Status_Functionalities extends Base {

	@Given("I am in Landing Page")
	public void i_am_in_Landing_Page() {
		navigateURL("https://sit.skyschooling.com/microtech");
		String welcomeString = getText(By.xpath("//div/h1"));
		assertEquals("Welcome to MicroTech NA.", welcomeString);
	}

	@When("I Click on Login")
	public void i_Click_on_Login() {
		 click(By.xpath("//a[@href=\"elogin.php\"]"));
	}

	@Then("I will be in Login Page")
	public void i_will_be_in_Login_Page() {
		String s=getText(By.xpath("//div//h1"));
		assertEquals("Employee Login",s);
	}

	@Then("Click Customer Login")
	public void click_Customer_Login() {
		click(By.xpath("//a[@href=\"clogin.php\"]"));
		String customerLogin= getText(By.xpath("//div/h1"));
		assertEquals("Customer Login", customerLogin);		
	}

	@Then("I enter User Id")
	public void i_enter_User_Id() {
		sendKeys(By.xpath("//input[@name='mailuid']"), "david@gmail.com");
	}

	@Then("I enter Password")
	public void i_enter_Password() {
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");
	}

	@When("I click Login Button")
	public void i_click_Login_Button() {
		click(By.name("login-submit"));
	}
	
	@Then("I will see Customer Home Page")
	public void i_will_see_Customer_Home_Page() {
		String welcomeName= getText(By.xpath("//h2[2]"));
		assertEquals("Welcome David", welcomeName);		
	}
	
	@Then("I will click Order Product")
	public void i_will_click_Order_Product() {
		click(By.xpath("//a[@href=\"productOrder.php?id=4\"]"));
	}

	@Then("I select product")
	public void i_select_product() {
		sendKeys(By.xpath("//select[@name=\"prodId\"]"), "Pencil");
	}

	
	@Then("I enter order date")
	public void i_enter_order_date() {
		sendKeys(By.xpath("//input[@name='ordDate']"), "12-01-2021");
		
	}

	@Then("I click order Product button")
	public void i_click_order_Product_button() {
		click(By.xpath("//button[text()='Order Product']"));
	}

	@Then("I will see {string} home Page")
	public void i_will_see_home_Page(String string) {
		String s=getText(By.xpath("//h1[@id='orderList-title']"));
		assertEquals("Order List",s);
	}

	@Then("I click confirm button")
	public void i_click_confirm_button() {
		click(By.xpath("//a[@href='orderSubmit.php?ordId=118&id=4']"));
	}

	@Then("refresh Url")
	public void refresh_Url() {
		driver.navigate().refresh();
		
	}

	@Then("I will see {string} status")
	public void i_will_see_status(String string) {
		String s=getText(By.xpath("//tbody/tr[15]/td[text()='Confirmed']"));
		System.out.println("complete "+ s);
		assertEquals("Confirmed",s);
	}
	
}
