package robot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import base.base;

public class ScreenCaptureDemo extends base {
	

	public ScreenCaptureDemo() {
		super();
	}

	public static void main(String[] args) throws IOException{
		initilization();
		driver.findElement(By.id("input-email")).sendKeys(props.getProperty("tutorialsninja_Email"));
		driver.findElement(By.id("input-password")).sendKeys(props.getProperty("tutorialsninja_Password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("HP");
	
		try {
			//Taking Screenshot using Rectangle
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			Rectangle rectangle = new Rectangle(25, 50, 1000, 300);
			BufferedImage srcImage = robot.createScreenCapture(rectangle); // takes the screen shot
			ImageIO.write(srcImage, "PNG", new File("./screenshots/robot.png"));
			
			
			//Taking Screenshot using Dimension
			Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle2 = new Rectangle(d);
			BufferedImage srcFile2 = robot.createScreenCapture(rectangle2);
			ImageIO.write(srcFile2, "PNG", new File("./screenshots/robot2.png"));
		} catch (AWTException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
