package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"Sanity","login"})
	public void Setup() throws InterruptedException, IOException {
	
		FileReader file=new FileReader(".//src/test/resources//config.properties");
		logger = LogManager.getLogger(this.getClass());
		p=new Properties();
		p.load(file);
		
		logger.info("***Start First TestCase ****");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL1"));
		driver.manage().window().maximize();
		driver.navigate().refresh();

		/*HomePage hp = new HomePage(driver);
		driver.navigate().refresh();
		hp.username(p.getProperty("Username"));
		hp.Password(p.getProperty("Password"));
		hp.Loginbtn();
		Thread.sleep(5000);
		hp.getConfirmationmsg();
		System.out.println("login Sucssefully Done"); 
*/
	}

	@AfterClass(groups= {"Sanity","login"})
	public void tearDown() {
		driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(6);
		return generatedString;
	}

	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);

		return (str + "@" + num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	/*@DataProvider(name="dp")
	public static void ReadJson() throws IOException, ParseException
	{
		JSONParser jsonParser=new JSONParser();
		FileReader reader=new FileReader(".\\jsonfiles\\testdata.json");
		Object obj=jsonParser.parse(reader);
		JSONObject Userloginobj=(JSONObject)obj;
		JSONArray userloginsarray=(JSONArray)Userloginobj.get("userlogins");
		
		String arr[]=new String[userloginsarray.size()];
		for(int i=0;i<userloginsarray.size().i++)
		{*/
			

	 public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException {
	        JSONParser jsonParser = new JSONParser();
	        Object obj = jsonParser.parse(new FileReader(fileLocation));
	        JSONObject jsonObject = (JSONObject) obj;
	       
	        
	        return jsonObject;
	    }


		 
}

	



