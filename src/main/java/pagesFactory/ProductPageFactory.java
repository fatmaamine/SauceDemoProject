package pagesFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.CartProductsPage;

public class ProductPageFactory {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class=\"title\"]")
	WebElement headerProductPageWE;
	
	@FindBy(xpath="(//div[@class=\"inventory_item_name \"] )[2]")
	WebElement productchooseWE;
	
	@FindBy(xpath="(//div[@class=\"inventory_item_desc\"])[2]")
	WebElement productDescWE;
	
	@FindBy(xpath="(//div[@class=\"inventory_item_price\"])[2] ")
	WebElement productPriceWE;
	
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")
	WebElement buttonAddProductWE;
	
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
	WebElement shoppingCartLinkWE;

	public ProductPageFactory(WebDriver driverWeb) {
		// TODO Auto-generated constructor stub
		this.driver=driverWeb;
	    PageFactory.initElements(driver, this);
	}
	public void checkOpenProductPage()
	{
		Assert.assertEquals(headerProductPageWE.getText(), "Products","Not equals");
		System.out.println("Vérifier l’ouverture de la page qui contient les Product :" + headerProductPageWE.getText());

	}
	public void chooseProductAndShowDescPrice()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Assert.assertEquals(productchooseWE.getText(), "Sauce Labs Bike Light","Not equals");
		
		
		
		System.out.println("Product Description: " + productDescWE.getText());
		System.out.println("Product Price: " + productPriceWE.getText() );
		
	}
	
	public CartProductsPage addProductAndClickCart()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		buttonAddProductWE.click();
		
		shoppingCartLinkWE.click();
		return new  CartProductsPage(driver);
	}
	

}
