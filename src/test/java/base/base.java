package base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public static Properties props;
	public static WebDriver driver;
	static String configPath="E:\\WorkSpace\\cautious-potato\\"
			+ "src\\test\\java\\Config\\config.properties";
    public static void initilization() throws IOException {
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
    	System.out.println(browser);
    	if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		System.out.println(props.getProperty("browser")+" is Launching!");
    	
    	}else if(browser.equalsIgnoreCase("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    		System.out.println(driver.getTitle()+ "is launched!");
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    	driver.get(props.getProperty("omayoURL"));
    	
    }
    public static void logOut() {
    	System.out.println(props.getProperty("browser") + " is Shutting Down!");
    	driver.quit();
    }
	public static void main(String[] args) throws IOException {}

}
