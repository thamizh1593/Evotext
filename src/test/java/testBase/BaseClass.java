package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"Smoke","Regression"})
	@Parameters({"os","browser"})
	public void setUp(@Optional("Windows")String os,String br) throws IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		p=new Properties();
		p.load(fr);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No Matching Platform");
				return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge"); break;
			default:System.out.println("No Matching Browser");return;
			}
			driver = new RemoteWebDriver(new URL("http://192.168.1.14:4444/wd/hub"),capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		
        switch(br.toLowerCase()) {
		
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser");return;
		}	
        
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@AfterClass(groups= {"Smoke","Regression"})
	public void tearDown() {
		//driver.quit();
	}
	
	public String randomalphabet() {
		//one method
		
		String generatedRandomString = RandomStringUtils.randomAlphabetic(5);
		return generatedRandomString;
		
		//2nd method
		/*
		RandomStringGenerator.builder().withinRange('a','z').build().generate(5);
		*/
	}
	
	public String randomNumber() {
		String generatedRandomNumber = RandomStringUtils.randomNumeric(3);
		return generatedRandomNumber;
	}
	
	public String randomAlphanumeric() {
		String generatedrandomString= RandomStringUtils.randomAlphanumeric(5);
		String generatedrandomnumber = RandomStringUtils.randomNumeric(5);
		return (generatedrandomString+"@"+generatedrandomnumber);
	}
	
	public String captureScreen(String name) {
		String timestamp = new SimpleDateFormat("MMDDYYYY_hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timestamp+".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}

}
