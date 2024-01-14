package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormPage {
WebDriver driver;
	
	By usernameInputBy= By.xpath("//input[contains(@id, \"user-name\")]");
	WebElement usernameInputWE;
	
	By passwordInputBy= By.xpath("//input[contains(@id, \"password\")]");
	WebElement passwordInputWE;	

	
	By signinButtonBy= By.xpath("//input[@id=\"login-button\"]");
	WebElement signinButtonWE;
	
	By msgErrorBy= By.xpath("//h3[@data-test=\"error\"]");
	WebElement msgErrorWE;
	
	By buttonMsgErrorBy=By.xpath("//button[@class=\"error-button\"]");
	WebElement buttonMsgErrorWE;

	public LoginFormPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void verifierMsgErreur()

	{
		msgErrorWE=driver.findElement(msgErrorBy);
		System.out.println("Verifier message d'erreur:" +msgErrorWE.getText() );
		msgErrorWE=driver.findElement(buttonMsgErrorBy);
		msgErrorWE.click();
		
	}
	public void saisirLoginPassword(String login,String password)
	{
		usernameInputWE = driver.findElement(usernameInputBy);
		usernameInputWE.clear();
		usernameInputWE.sendKeys(login);
		
		passwordInputWE = driver.findElement(passwordInputBy);
		passwordInputWE.clear();
		passwordInputWE.sendKeys(password);
	}
	
	public ProductPage cliquerSignIn() {
		signinButtonWE = driver.findElement(signinButtonBy);
		signinButtonWE.click();
		return new ProductPage(driver);

	}
}
