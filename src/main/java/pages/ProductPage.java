package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage {
	WebDriver driver;
	By headerProductPageBy= By.xpath("//span[@class=\"title\"]");
	WebElement headerProductPageWE;
	
	By productchooseBy= By.xpath("(//div[@class=\"inventory_item_name \"] )[2]");
	WebElement productchooseWE;
	
	By productDescBy= By.xpath("(//div[@class=\"inventory_item_desc\"])[2]");
	WebElement productDescWE;
	
	By productPriceBy= By.xpath("(//div[@class=\"inventory_item_price\"])[2] ");
	WebElement productPriceWE;
	
	By buttonAddProductBy=By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]");
	WebElement buttonAddProductWE;
	
	By shoppingCartLinkBy= By.xpath("//a[@class=\"shopping_cart_link\"]");
	WebElement shoppingCartLinkWE;
	


	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void checkOpenProductPage()
	{
		headerProductPageWE = driver.findElement(headerProductPageBy);
		Assert.assertEquals(headerProductPageWE.getText(), "Products","Not equals");
		System.out.println("Vérifier l’ouverture de la page qui contient les Product :" + headerProductPageWE.getText());

	}
	public void chooseProductAndShowDescPrice()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		productchooseWE = driver.findElement(productchooseBy);
		Assert.assertEquals(productchooseWE.getText(), "Sauce Labs Bike Light","Not equals");
		
		productDescWE = driver.findElement(productDescBy);
		productPriceWE = driver.findElement(productPriceBy);
		
		System.out.println("Product Description: " + productDescWE.getText());
		System.out.println("Product Price: " + productPriceWE.getText() );
		
	}
	
	public CartProductsPage addProductAndClickCart()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		buttonAddProductWE = driver.findElement(buttonAddProductBy);
		buttonAddProductWE.click();
		
		shoppingCartLinkWE = driver.findElement(shoppingCartLinkBy);
		shoppingCartLinkWE.click();
		return new  CartProductsPage(driver);
	}
}
