package com.example.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DemoApplication {
		
	public static void main(String[] args) throws AWTException, InterruptedException {

		int run = 100000000;
		Robot robot = new Robot();
		for (int l = 0; l < run; l++) {
			int 	k = Integer.valueOf(RandomStringUtils.randomNumeric(2, 2));
			int m = Integer.valueOf(RandomStringUtils.randomNumeric(2, 2));
			int max = k >= m ? k : m;
			int wait = 600000 / max;
			System.out.println("===" + k + "," + m + "," + wait + "===");
			System.out.println("CYCLe");
			for (int i = 0; i < max; i++) {
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_ALT);	
				System.out.println("KC---" + System.currentTimeMillis());
				Thread.sleep(wait)
				;
			}
		}
	}
}
