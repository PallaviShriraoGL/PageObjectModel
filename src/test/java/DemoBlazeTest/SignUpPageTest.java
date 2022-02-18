package DemoBlazeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import DemoBlazePage.LoginPage;
import DemoBlazePage.SignUpPage;

public class SignUpPageTest extends TestBase{
	LoginPage l;
	SignUpPage sp;
	static Workbook book;
	static Sheet sheet;
	public SignUpPageTest() {
		super();
	}
	@BeforeMethod
	public void initialize() {
	initialization();
	sp=new SignUpPage();
	l=new LoginPage();
	
	}
	public static Object[][] getTestData() {
		FileInputStream file = null;
		try {
			file = new FileInputStream("SignUpData.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("Sheet1");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	@DataProvider
	public Object[][] getFormPageData() {
		Object data[][] = getTestData();
		return data;
	}

	@Test(dataProvider = "getFormPageData")
	public void signUpForm(String Name, String Password) throws Exception {
		sp.signUp(Name, Password);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}
		
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
