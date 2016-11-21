package com.test.dataprovider;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.xueba.dataprovider.DataProviderYaml;

public class DataProviderYamlTest {
	
	@Test(dataProvider = "yamlDataProvider1", dataProviderClass = DataProviderYaml.class)
	public void testMethod1(String testData) {
		System.out.println("testMethod1: " + testData);
	}
	
	
	@Test(dataProvider = "yamlDataProvider2", dataProviderClass = DataProviderYaml.class)
	public void testMethod2(String testData) {
		System.out.println("testMethod2: " + testData);
	}
	
	@Test(dataProvider = "yamlDataProvider3", dataProviderClass = DataProviderYaml.class) 
	public void testMethod3(HashMap<Object, Object> testData) {
		System.out.println("testMethod3: " + testData);
	}
	
	@Test(dataProvider = "yamlDataProvider4", dataProviderClass = DataProviderYaml.class)
	public void testMethod4(HashMap<Object, Object> testData) {
		System.out.println("testMethod4: " + testData);
		
	}
	
}
