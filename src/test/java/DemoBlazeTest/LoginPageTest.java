package DemoBlazeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import DemoBlazePage.HomePage;
import DemoBlazePage.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage l;
	HomePage h;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void initialize() {
	initialization();
	System.out.println(driver.getCurrentUrl());
	l=new LoginPage();
	}
	@Test
	public void loginTest() throws InterruptedException {
		
	 h=l.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(3000);
}
		
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}