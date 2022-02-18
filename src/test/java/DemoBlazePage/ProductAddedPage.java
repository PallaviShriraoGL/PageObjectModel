package DemoBlazePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class ProductAddedPage extends TestBase{
		@FindBy(partialLinkText ="Place")
		WebElement placeOrderLink;
		@FindBy(partialLinkText ="Cart")
		WebElement cartLink;
		
		public ProductAddedPage() {
			PageFactory.initElements(driver, this);
		}
		public PlaceOrderPage placeOrder() {
		
			//placeOrderLink.click();
			//driver.switchTo().alert().accept();
			cartLink.click();
			return new PlaceOrderPage();
		}
	}