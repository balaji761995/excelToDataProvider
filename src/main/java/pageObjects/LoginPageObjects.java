package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	
	@FindBy(id="inputEmail")
	WebElement emailAddress;
	
	@FindBy(id="inputPassword")
	WebElement password;
	

	
	public WebElement enterEmail()
	{
		return emailAddress;
	}
	public WebElement enterPassword()
	{
		return password;
	}

}
