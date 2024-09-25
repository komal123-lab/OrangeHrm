package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CreateEmp;
import PageObject.HomePage;



public class LoginPage extends BasePage{
	CreateEmp emp;
	HomePage ho;
	
	@Test(priority=1)
	public void ValidLogin() throws InterruptedException
	{
		ho=new HomePage(driver);
		emp=new CreateEmp(driver);
		logger.info("***Start Emp Creations with Property Case ****");
		ho = new HomePage(driver);
		ho.username(p.getProperty("Username"));
		ho.Password(p.getProperty("Password"));
		ho.Loginbtn();
		Thread.sleep(5000);
		ho.getConfirmationmsg();
		System.out.println("login Sucssefully Done"); 
		emp.logout();
		
	}
	@Test(priority=2)
	public void InValidLogin() throws InterruptedException, IOException, ParseException
	{
		driver.navigate().refresh();
		ho=new HomePage(driver);
		logger.info("***Start Invalid Json Login ****");
		JSONObject userObject = BasePage.loadJSONFile(".\\json\\empcreditons.json");
	     String Username = userObject.get("username").toString();
	    ho.username(Username);
	    logger.info("Login with Invalid username");
	    
		//Thread.sleep(5000);
		logger.info("Login with valid Json Pasword");
		String Password = userObject.get("Password").toString();
		ho.Password(Password);
		ho.Loginbtn();
		Thread.sleep(5000);	
		Assert.assertTrue(emp.isEmpVisible(), "valid Password");
		System.out.println("valid Password");
		logger.info("Login is succsefully Done");

		}
	
	
			}

		
		
		
	
	
	

	


