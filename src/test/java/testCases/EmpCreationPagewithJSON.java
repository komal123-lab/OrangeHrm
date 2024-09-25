package testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CreateEmp;
import PageObject.HomePage;
 
public class EmpCreationPagewithJSON extends BasePage{
	
	CreateEmp emp;
	BasePage BC;
	HomePage ho;
	private String Nuname;
	private String PWD;
		
	@Test
	public void CreateEmp() throws InterruptedException, IOException, ParseException
	{
	logger.info("***Start Emp Creations with JSON Case ****");
	emp=new CreateEmp(driver);
	BC=new BasePage();
	ho = new HomePage(driver);
	ho.username(p.getProperty("Username"));
	ho.Password(p.getProperty("Password"));
	ho.Loginbtn();
	Thread.sleep(5000);
	//ho.getConfirmationmsg();
	//System.out.println("login Sucssefully Done"); 

	emp.PIM(); 
	emp.AddEmp();
	logger.info("Enter First Name");
	//String FirstName=BC.randomeString();
	
	 JSONObject userObject = BasePage.loadJSONFile(".\\json\\empcreditons.json");
     String FirstName = userObject.get("Firstname").toString();
     emp.FirstName(FirstName);
     
     logger.info("Enter Middel Name");
 	 emp.MiddelName(BC.randomeString());
 	
 	
     String Lastname = userObject.get("Lastname").toString();
     emp.Lastname(Lastname);
	logger.info("Enter Last Name");
	//emp.Lastname(BC.randomeString());
	
	
	String Dis=emp.Empgetcode();
	logger.info("Swap tongle");
	emp.tonggle_Drag();
	logger.info("Enter Username Name");
	
	
	//Nuname=BC.randomeString();
	this.Nuname = userObject.get("username").toString();
    emp.NewUnme(Nuname);
    
	logger.info("Enter Password");
	//PWD=BC.randomAlphaNumeric();  //Capture pwd
	this.PWD = userObject.get("Password").toString();
	emp.NewPwd(PWD);

	
	logger.info("Click Submit button");
	emp.NSubmit();
	logger.info("check Personal Details visible or not");
	Thread.sleep(5000);
	Assert.assertTrue(emp.isEmpdetailsvisible(), "The Emp Name is not visible!");
   
	System.out.println("New ID Creation Details below : ");
	System.out.println("Emp Name is"+FirstName);
	System.out.println("Emp Name is"+Lastname);
	System.out.println("Emp Code is"+Dis);
	System.out.println("Emp New Username : "+Nuname);
	System.out.println("Emp New Password : "+PWD);
	logger.info("Log out the page");
	emp.logout();
	}
	
	@Test()
	public void loginwithNewEmp() throws InterruptedException
	{
	ho=new HomePage(driver);	
	logger.info("Login with New EMP username");
	ho.username(this.Nuname);
	//Thread.sleep(5000);
	logger.info("Login with New EMP Pasword");
	ho.Password(this.PWD);
	ho.Loginbtn();
	Thread.sleep(5000);
	logger.info("Login succsefully Done");
	Assert.assertTrue(emp.isEmpVisible(), "The Emp Name is visible!");
	System.out.println("New EMP login Sussessfully");

	}
	}

	


