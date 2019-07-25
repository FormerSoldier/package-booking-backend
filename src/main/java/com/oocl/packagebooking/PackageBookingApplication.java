package com.oocl.packagebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.oocl.packagebooking.service","com.oocl.packagebooking.controller"})
@SpringBootApplication
public class PackageBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackageBookingApplication.class, args);
	}

}
