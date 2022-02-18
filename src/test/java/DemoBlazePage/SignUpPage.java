package DemoBlazePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class SignUpPage extends TestBase {
	@FindBy(partialLinkText = "Sign up")
	public WebElement signInLink;
	@FindBy(id = "sign-username")
	public WebElement un;
	@FindBy(id = "sign-password")
	public WebElement pw;
	@FindBy(xpath = "//button[text()='Sign up']")
	public WebElement signInBtn;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage signUp(String Name,String pass) {
		signInLink.click();

		un.sendKeys(Name);
		pw.sendKeys(pass);
		signInBtn.click();
		return new LoginPage();
	}
	
}