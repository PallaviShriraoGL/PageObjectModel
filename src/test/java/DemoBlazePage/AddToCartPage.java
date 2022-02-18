package DemoBlazePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class AddToCartPage extends TestBase{
	@FindBy(partialLinkText ="Add")
	WebElement addToCartLink;
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	public ProductAddedPage addToCartProduct() {
		addToCartLink.click();
		return new ProductAddedPage();
	}
}