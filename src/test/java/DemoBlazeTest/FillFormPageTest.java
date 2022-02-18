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
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import DemoBlazePage.AddToCartPage;
import DemoBlazePage.FillFormPage;
import DemoBlazePage.HomePage;
import DemoBlazePage.LoginPage;
import DemoBlazePage.PlaceOrderPage;
import DemoBlazePage.ProductAddedPage;
public class FillFormPageTest extends TestBase {

	static Workbook book;
	static Sheet sheet;
	LoginPage l;
	HomePage h;
	AddToCartPage a;
	ProductAddedPage p;
	PlaceOrderPage po;
	FillFormPage ff;

	SoftAssert s_assert = new SoftAssert();

	public FillFormPageTest() {
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
		ff = po.fillForm();
		

	}

	public static Object[][] getTestData() {
		FileInputStream file = null;
		try {
			file = new FileInputStream("FillForm.xls");
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
	public void fillOrderForm1(String Name, String countryN, String cityN, String crediCard, String monthN,
			String yearN) throws Exception {
		ff.fillOrderForm(Name, countryN, cityN, crediCard, monthN, yearN);
		Thread.sleep(3000);

		FillFormPage.takeSnapShot(driver);
		s_assert.assertTrue(ff.validateTitle());
		System.out.println("Soft Assertion -> 1st site name assertion executed.");

		s_assert.assertTrue(ff.validatePurchaseMessage());
		System.out.println("Soft Assertion -> 2nd validatePurchaseMessage assertion executed.");
		ff.clickOk();
		Thread.sleep(2000);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
