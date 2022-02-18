package DemoBlazePage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class FillFormPage extends TestBase {
	@FindBy(id = "name")
	public WebElement name;
	
	@FindBy(id = "country")
	public WebElement country;
	
	@FindBy(id = "city")
	public WebElement city;
	@FindBy(id = "card")
	public WebElement card;
	@FindBy(id = "month")
	public WebElement month;
	@FindBy(id = "year")
	public WebElement year;
	@FindBy(xpath = "//button[text()='Purchase']")
	public WebElement purchaseBtn;
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement closeBtn;
	@FindBy(xpath = "//div[10]//h2")
	public WebElement purchaseMessage;
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement okBtn;
	public FillFormPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillOrderForm(String Name, String countryN, String cityN, String crediCard, String monthN,
			String yearN) {
		sendData1(name, Name);
		sendData1(country, countryN);
		sendData1(city, cityN);
		sendData1(card, crediCard);
		sendData1(month, monthN);
		sendData1(year, yearN);
		purchaseBtn.click();
	}

	public void sendData1(WebElement element, String value) {
		element.sendKeys(value);
	}
	public boolean validatePurchaseMessage() {
		WebElement msg = purchaseMessage;
		String text = msg.getText();
		String expectedText = "Thank you for your purchase!";
		if (text.equalsIgnoreCase(expectedText))
			return true;
		else
			return false;
	}

	public boolean validateTitle() {
		String title = driver.getTitle();

		String expectedTitle = "STORE";
		if (title.equalsIgnoreCase(expectedTitle))
			return true;
		else
			return false;
	}

	public void clickOk() {
		okBtn.click();

	}
	public static void takeSnapShot(WebDriver webdriver) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File("ScreenShot.png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
}
