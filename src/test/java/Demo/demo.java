package Demo;

import java.io.IOException;

import base.base;

public class demo extends base {

//	public demo() throws IOException {
//		super();
//
//	}
	public static void main(String[] args) throws IOException{
		initilization();
		System.out.println("Calling Base Class for Launching :" +props.getProperty("browser"));
		try {
		Thread.sleep(3000);
		logOut();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
