package DemoBlazeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import DemoBlazePage.AddToCartPage;
import DemoBlazePage.HomePage;
import DemoBlazePage.LoginPage;
import DemoBlazePage.ProductAddedPage;

public class AddToCartPageTest extends TestBase{
	LoginPage l;
	HomePage h;
	AddToCartPage a;
	ProductAddedPage p;
	
	public AddToCartPageTest() {
		super();
	}

	@BeforeMethod
	public void initialize() throws InterruptedException {
		initialization();
		l=new LoginPage();
		h = l.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		a=h.scrollToProduct();
		p=new ProductAddedPage();
	}
@Test
public void add() throws InterruptedException {
	
	Thread.sleep(3000);
	p=a.addToCartProduct();
	Thread.sleep(3000);

}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}