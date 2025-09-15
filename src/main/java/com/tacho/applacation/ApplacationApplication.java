package com.tacho.applacation;

import com.tacho.applacation.windowHandle.CustonFormatter;
import com.tacho.applacation.windowHandle.windowHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class ApplacationApplication {
	public static final Logger logger = Logger.getLogger("taco");
	private static final CustonFormatter formatter = new CustonFormatter();
	private static final windowHandler windowHandler = new windowHandler();

	static {
		logger.setLevel(Level.ALL);
		windowHandler.setFormatter(formatter);
		logger.setUseParentHandlers(false);
		logger.addHandler(windowHandler);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplacationApplication.class, args);
	}

}
