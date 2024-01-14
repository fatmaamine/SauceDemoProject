package pagesFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartProductsPageFactory {
	
  WebDriver driver;
	
  @FindBy(xpath="//span[@class=\"title\"]")
	WebElement headerCartProductsPageWE;
	
 
  By productInCartBy= By.xpath("//div[@class=\"cart_item\"]");
	WebElement productInCartWE;
	
  @FindBy(xpath="//button[@id=\"remove-sauce-labs-bike-light\"]")
	WebElement buttonRemoveWE;
	
  @FindBy(xpath="//div [@class=\"cart_item\"]")
	WebElement productRemoveWE;

	public CartProductsPageFactory( WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}

	public void checkOpenCartProductsPage()
	{
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
