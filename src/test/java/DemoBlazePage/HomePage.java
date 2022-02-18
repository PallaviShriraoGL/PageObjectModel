package DemoBlazePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.TestBase;

public class HomePage extends TestBase{
	@FindBy(partialLinkText ="Samsung galaxy s6")
	WebElement link;
	
	
public HomePage() {
	PageFactory.initElements(driver, this);
}

public AddToCartPage scrollToProduct()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", link);
	link.click();
	return new AddToCartPage();
}
}