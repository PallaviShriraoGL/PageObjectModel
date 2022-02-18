package DemoBlazeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import DemoBlazePage.AddToCartPage;
import DemoBlazePage.FillFormPage;
import DemoBlazePage.HomePage;
import DemoBlazePage.LoginPage;
import DemoBlazePage.PlaceOrderPage;
import DemoBlazePage.ProductAddedPage;

public class PlaceOrderPageTest extends TestBase {
	LoginPage l;
	HomePage h;
	AddToCartPage a;
	ProductAddedPage p;
	PlaceOrderPage po;
	FillFormPage ff;

	public PlaceOrderPageTest() {
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
		po = p.placeOrder();
		ff=new FillFormPage();
	}

	@Test
	public void fillOrderForm() throws InterruptedException {
		ff=po.fillForm();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
