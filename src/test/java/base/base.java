package base;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public static Properties props;
	public static WebDriver driver;
	public static Logger log;
	static String configPath="E:\\WorkSpace\\cautious-potato\\"
			+ "src\\test\\java\\Config\\config.properties";
    public static void initilization() throws IOException {
    	log = LogManager.getLogger(base.class.getName());
    	
    	try {
    		props = new Properties();
    		FileInputStream ip = new FileInputStream(configPath);
    		props.load(ip);
    		}catch(FileNotFoundException e) {
    		e.printStackTrace();
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    	String browser = props.getProperty("browser");
    	log.debug("Launching "+browser+"...");
    	System.out.println(browser);
    	if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		log.debug(props.getProperty("browser")+" is Launching!");
    	
    	}else if(browser.equalsIgnoreCase("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    		log.debug(driver.getTitle()+ "is launched!");
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    	driver.get(props.getProperty("omayoURL"));
    	log.debug("Launched Application");
    	
    }
//    public static void logOut() {
//    	logOut();
//    	log.debug(props.getProperty("browser") + " is Shutting Down!");
//    	driver.quit();
//    }
	public static void main(String[] args) throws IOException {}

}
