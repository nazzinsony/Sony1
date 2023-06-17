package definitions;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base {
	@Before
	public void setup() {
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
}
