package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txtunam;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtpwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement Verifymsg;
	
	//Action Method

	public void username(String uname) {
		txtunam.sendKeys(uname);
	}
	
	public void Password(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	
	public void Loginbtn()
	{
		loginbtn.click();
	}
	
	public void getConfirmationmsg()
	{
		Verifymsg.isDisplayed();
	}

}
