package pagesFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.ProductPage;

public class LoginFormPageFactory {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[contains(@id, \"user-name\")]")
	WebElement usernameInputWE;
	
	@FindBy(xpath="//input[contains(@id, \"password\")]")
	WebElement passwordInputWE;	

	
	@FindBy(xpath="//input[@id=\"login-button\"]")
	WebElement signinButtonWE;
	
	@FindBy(xpath="//h3[@data-test=\"error\"]")
	WebElement msgErrorWE;
	
	@FindBy(xpath="//button[@class=\"error-button\"]")
	WebElement buttonMsgErrorWE;

	public LoginFormPageFactory(WebDriver driverWeb) {
		// TODO Auto-generated constructor stub
		this.driver=driverWeb;
	    PageFactory.initElements(driver, this);
	}
	
	public void verifierMsgErreur()

	{
		System.out.println("Verifier message d'erreur:" +msgErrorWE.getText() );
		msgErrorWE.click();
		
	}
	public void saisirLoginPassword(String login,String password)
	{
		usernameInputWE.clear();
		usernameInputWE.sendKeys(login);
		
		passwordInputWE.clear();
		passwordInputWE.sendKeys(password);
	}
	
	public ProductPage cliquerSignIn() {
		signinButtonWE.click();
		return new ProductPage(driver);

	}

}
