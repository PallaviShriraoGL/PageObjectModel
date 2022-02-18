package DemoBlazePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "login2")
	WebElement logInBtn;
	
	@FindBy(id = "loginusername")
	WebElement un;
	
	@FindBy(id = "loginpassword")
	WebElement pw;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement innerLogInBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String unm, String pass) {
		logInBtn.click();
		un.sendKeys(unm);
		pw.sendKeys(pass);
		innerLogInBtn.click();
		return new HomePage();
	}
}
