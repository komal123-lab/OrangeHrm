package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CreateEmp;
import PageObject.HomePage;
 
public class EmpCreationPage extends BasePage{
	
	CreateEmp emp;
	BasePage BC;
	HomePage ho;
	private String Nuname;
	private String PWD;
		
	@Test(groups="Sanity")
	public void CreateEmp() throws InterruptedException
	{
	logger.info("***Start Emp Creationt test Case ****");
	emp=new CreateEmp(driver);
	BC=new BasePage();
	ho = new HomePage(driver);
	ho.username(p.getProperty("Username"));
	ho.Password(p.getProperty("Password"));
	ho.Loginbtn();
	Thread.sleep(5000);
	logger.info("Go to PIM");
	emp.PIM(); 
	logger.info("Click on Emp");
	emp.AddEmp();
	logger.info("Enter First Name");
	String FirstName=BC.randomeString();
	emp.FirstName(FirstName);
	logger.info("Enter Middel Name");
	emp.MiddelName(BC.randomeString());
	logger.info("Enter Last Name");
	emp.Lastname(BC.randomeString());
	String Dis=emp.Empgetcode();
	logger.info("Swap tongle");
	emp.tonggle_Drag();
	logger.info("Enter Username Name");
	Nuname=BC.randomeString();
	emp.NewUnme(Nuname);
	//Assert.assertEquals(true, emp.checkbox());
	logger.info("Enter Password");
	PWD=BC.randomAlphaNumeric();  //Capture pwd
	emp.NewPwd(PWD);
	Nuname=BC.randomeString();
	emp.NewUnme(Nuname);
	//Assert.assertEquals(true, emp.checkbox());
	logger.info("Enter Password");
	PWD=BC.randomAlphaNumeric();  //Capture pwd
	emp.NewPwd(PWD);
	
	logger.info("Click Submit button");
	emp.NSubmit();
	logger.info("check Personal Details visible or not");
	Thread.sleep(5000);
	Assert.assertTrue(emp.isEmpdetailsvisible(), "The Emp Name is  visible!");
   
	System.out.println("New ID Creation Details below : ");
	System.out.println("Emp Name is"+FirstName);
	System.out.println("Emp Code is"+Dis);
	System.out.println("Emp New Username : "+Nuname);
	System.out.println("Emp New Password : "+PWD);
	logger.info("Log out the page");
	emp.logout();
	}
	
	@Test(groups="Login")
	public void login() throws InterruptedException
	{
	ho=new HomePage(driver);
	try {
	driver.navigate().refresh();	
	logger.info("Login with New EMP username");
	ho.username(Nuname);
	//Thread.sleep(5000);
	logger.info("Login with New EMP Pasword");
	ho.Password(PWD);
	ho.Loginbtn();
	Thread.sleep(5000);
	logger.info("Login succsefully Done");
	Assert.assertTrue(emp.isEmpVisible(), "The Emp Name is visible!");
	System.out.println("New EMP login Sussessfully");
	}
	catch (Exception e)
	{
		logger.error("Test Failed");
		logger.debug("Debug Log");
		Assert.fail(); 
	}
	}
}


	


