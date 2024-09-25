package PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmp extends BaseObject{
	
	WebDriverWait wait;
	
	public CreateEmp(WebDriver driver) {
		super(driver);
	}
	
	//Clik on PIM
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
	WebElement btnPIM;
	
	@FindBy(xpath="//button[normalize-space()='Add']")  //Add button
	WebElement btnAdd;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement Fname;
	
	@FindBy(xpath="//input[@placeholder='Middle Name']")
	WebElement Mname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement Lname;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement get_code;
	
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	WebElement tongle;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement new_unam; // Enter Username
	
	@FindBy(xpath="//label[normalize-space()='Enabled']")
	WebElement Chebox;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement txtNpwd;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txtCpwd;

	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement btnsave;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement EmpDetails_conf;  																			//Confirm Emp Caretion 
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement Drp_Logout; 																					//click on Logout Dropdown
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement btn_Logout; 																					//click on Logout btn

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement new_txtpwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement new_loginbtn;

	@FindBy(xpath = "//span[normalize-space()='My Info']")
	WebElement new_Verifymsg;
	
	
	
	//Action method
	public void PIM()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btnPIM));
		System.out.println("PIM is Disable"+btnPIM.isDisplayed());
		btnPIM.click();
	}
	
	//Clik on Add Emp button
	public void AddEmp()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btnAdd));
		btnAdd.click();
	}
	
	//Enter First Name
	public void FirstName(String Ename)
	{	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Fname));
		Fname.sendKeys(Ename);

	}
	//Enter First Name
	public void MiddelName(String mname)
	{
		Mname.sendKeys(mname);	
	}
	
	public void Lastname(String lname)
	{
		Lname.sendKeys(lname);
		//selrole.click();
	}
	public String Empgetcode()
	{
		get_code.getText();
		return null;
	
	}
public void tonggle_Drag() {
		
		tongle.click();
		
	}
	
	public void NewUnme(String Nname) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);",new_unam); 
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(new_unam));
		new_unam.sendKeys(Nname);
		
		//selrole.click();
	}
	public Boolean checkbox()
	{
		Chebox.isDisplayed();
		return true;
		//selrole.click();
	}
	public void NewPwd(String Pwd)
	{
		txtNpwd.sendKeys(Pwd);
		//selrole.click();
		txtCpwd.sendKeys(Pwd);
	}
	
	public void NSubmit()
	{
		btnsave.click();
		
		//selrole.click();
	}
		
	public boolean isEmpdetailsvisible() {
        return EmpDetails_conf.isDisplayed();
    }

	public void logout()
	{
		Drp_Logout.click();
		btn_Logout.click();
	}
	
	
	public boolean isEmpVisible() {
        return new_Verifymsg.isDisplayed();
      
    }
	
	/* public boolean cofmsg()
	{
		conftxtmsg.isDisplayed();
		return true;
	} */
	
	

	

	
	
	
	
	
	
	

}
