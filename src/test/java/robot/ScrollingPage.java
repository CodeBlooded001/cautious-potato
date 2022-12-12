package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import base.base;

public class ScrollingPage extends base{

	public ScrollingPage() {
		super();
	}

	public static void main(String[] args) throws IOException {
		
		initilization();
		try {
			Robot robot = new Robot();
			robot.mouseWheel(15); //positive values - scrolls down
			robot.delay(2000);
			robot.mouseWheel(-8); //negative values - scrolls up
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
