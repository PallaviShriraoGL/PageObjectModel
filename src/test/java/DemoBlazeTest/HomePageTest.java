package DemoBlazeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import DemoBlazePage.AddToCartPage;
import DemoBlazePage.HomePage;
import DemoBlazePage.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage l;
	HomePage h;
	AddToCartPage a;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void initialize() {
		initialization();
		l=new LoginPage();
		h = l.login(prop.getProperty("username"), prop.getProperty("password"));
		a=new AddToCartPage();
	}
@Test
public void scroll() throws InterruptedException {
	Thread.sleep(5000);
	System.out.println(1);
	a=h.scrollToProduct();
	Thread.sleep(5000);
	System.out.println(1);
}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
