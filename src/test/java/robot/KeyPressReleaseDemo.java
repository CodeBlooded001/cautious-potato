package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;

import base.base;

public class KeyPressReleaseDemo extends base {

	public KeyPressReleaseDemo() {
		super();
	}

	public static void main(String[] args) throws IOException {
		
		initilization();
		driver.findElement(By.id("input-email")).sendKeys(props.getProperty("tutorialsninja_Email"));
		driver.findElement(By.id("input-password")).sendKeys(props.getProperty("tutorialsninja_Password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("HP");
		
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER); //enter key on keyboard
			robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(AWTException e) {
			e.printStackTrace();
		}
		
		
	}

}
