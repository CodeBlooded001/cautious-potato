package advancedTopics;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.base;

public class log4j extends base {
	public log4j() {
		super();

	}

	public static void main(String[] args) throws IOException {
		Logger log = LogManager.getLogger(log4j.class);
		initilization();
		// debug is for all general logs
		log.debug("Launching " + props.getProperty("browser") + " Browser!");
		driver.findElement(By.xpath("//p[@id='pah']"));
		log.debug("Find a paragraph text by using its xpath.");
		if (driver.getTitle().equals("omayo (QAFox.com)")) {
			// info is for successful test logs
			log.info("Success: The Correct Page Title is Displayed!");
		} else {
			// error for failure logs
			log.error("Failed: Wrong title is Displayed!");
		}
		driver.quit();
		log.info("Shutting down " + props.getProperty("browser"));

	}

}
