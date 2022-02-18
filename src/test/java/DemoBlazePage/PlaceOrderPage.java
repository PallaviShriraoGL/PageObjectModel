package DemoBlazePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class PlaceOrderPage extends TestBase {
	@FindBy(xpath ="//button[text()='Place Order']")
	WebElement placeOrderbtn;
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	public FillFormPage fillForm() {
		
		System.out.println(44);
		
		placeOrderbtn.click();
		return new FillFormPage();
	}
}
