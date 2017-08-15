package com.automation.utils;

import java.util.ArrayList;
import java.util.List;

import com.beust.testng.TestNG;

public class TestRunner {

	public static void main(String []args){
		TestNG runner =new TestNG();
		List<String> list= new ArrayList<String>();
		list.add("C:\\Users\\mom\\git\\kopal\\test-output\\Suite\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
	}
}
