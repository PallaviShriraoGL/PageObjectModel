package DemoBlazeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import DemoBlazePage.AddToCartPage;
import DemoBlazePage.HomePage;
import DemoBlazePage.LoginPage;
import DemoBlazePage.PlaceOrderPage;
import DemoBlazePage.ProductAddedPage;

public class ProductAddedPageTest extends TestBase {
	LoginPage l;
	HomePage h;
	AddToCartPage a;
	ProductAddedPage p;
	PlaceOrderPage po;

	public ProductAddedPageTest() {
		super();
	}

	@BeforeMethod
	public void initialize() throws InterruptedException {
		initialization();
		l = new LoginPage();
		h = l.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		a = h.scrollToProduct();
		p = a.addToCartProduct();

		po = new PlaceOrderPage();
	}

	@Test
	public void placeOrder() throws InterruptedException {
		System.out.println(22);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		po = p.placeOrder();
		Thread.sleep(3000);
		System.out.println(1);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
