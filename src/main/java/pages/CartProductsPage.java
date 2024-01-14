package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartProductsPage {
	WebDriver driver;
	
	By headerCartProductsPageBy= By.xpath("//span[@class=\"title\"]");
	WebElement headerCartProductsPageWE;
	
	By productInCartBy= By.xpath("//div[@class=\"cart_item\"]");
	WebElement productInCartWE;
	
	
	By buttonRemoveBy= By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]");
	WebElement buttonRemoveWE;
	
	By productRemoveBy= By.xpath("//div [@class=\"cart_item\"]");
	WebElement productRemoveWE;

	public CartProductsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void checkOpenCartProductsPage()
	{
		headerCartProductsPageWE = driver.findElement(headerCartProductsPageBy);
		Assert.assertEquals(headerCartProductsPageWE.getText(), "Your Cart","Not equals");
		System.out.println("Vérifier ouverture de la page de panier: : " + headerCartProductsPageWE.getText());

	}
	
	public void checkAddProductInCart()
	{
		List<WebElement> productInCart = driver.findElements(productInCartBy);
		if(productInCart.size() > 0)
		{
		System.out.println("le produit est bien ajouté ");
		for( WebElement product : productInCart)
		{
			System.out.println("Product: "+ product.getText());
			
		}
		}
		else
		{
			System.out.println("le produit n'est pas ajouté ");
		}
		
	}
	
	public void removeProduct()
	{
		
		buttonRemoveWE= driver.findElement(buttonRemoveBy);
		
		buttonRemoveWE.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
	}
	public void checkRemoveProduct()
	{
		 
		
		if(driver.findElements(By.className("cart_item")).isEmpty())
		{
			System.out.println("le produit est supprimé");
		}
		else
		{
			System.out.println("le produit existe");

		}
	}

}
