package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CartProductsPage;
import pages.LoginFormPage;
import pages.ProductPage;


public class PomSauceDemoTest {
	
	WebDriver driver;
	
	String siteDemo="https://www.saucedemo.com";
	
	String usernamecorrect="standard_user";
	String passwordcorrect="secret_sauce";
	
	String usernameFail="standard_user";
	String passwordFail = "standard_user";
	
	@BeforeTest
	public void Setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\Formation Testeur Logiciel\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
	}

	@Test
	public void sauceDemoTest() {
		
		driver.get(siteDemo);
		
		LoginFormPage loginformPage = new LoginFormPage(driver);
		
		loginformPage.saisirLoginPassword(usernameFail, passwordFail);
		loginformPage.cliquerSignIn();
		loginformPage.verifierMsgErreur();
		loginformPage.saisirLoginPassword(usernamecorrect, passwordcorrect);
		loginformPage.cliquerSignIn();
		
		ProductPage productPage = new ProductPage(driver);
		productPage.checkOpenProductPage();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		productPage.chooseProductAndShowDescPrice();

		productPage.addProductAndClickCart();
		
		
		CartProductsPage cartShopping = new CartProductsPage(driver);
		
		cartShopping.checkOpenCartProductsPage();

		cartShopping.checkAddProductInCart();

		cartShopping.removeProduct();
		
		cartShopping.checkRemoveProduct();

	}

	@AfterTest
	public void Teardown() throws Exception {
		//close browser
		this.takeSnapShot(driver, System.getProperty("user.dir")+"//Screenshots//test.png");

		driver.close();
	}

	private void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	private void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);
		this.copyFileUsingStream(SrcFile, DestFile);

	}


}
