package com.xueba.dataprovider;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.FileSystemResource;

public class DataProviderYaml {
	
	private static String filePath = "src/test/resources/testData/";
	
	@DataProvider(name = "yamlDataProvider1")
	public static Object[][] yamlDataProvider1() throws IOException {		
		FileSystemResource fileSystemResource = new FileSystemResource(filePath + "stringData.yaml");
		SeLionDataProvider seLionDataProvider = DataProviderFactory.getDataProvider(fileSystemResource);
		return seLionDataProvider.getAllData();
	}
	
	@DataProvider(name = "yamlDataProvider2")
	public static Object[][] yamlDataProvider2() throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(filePath + "stringData.yaml");
		SeLionDataProvider seLionDataProvider = DataProviderFactory.getDataProvider(fileSystemResource);
		String indexes = "1, 3";
		return seLionDataProvider.getDataByIndex(indexes);
	}
	
	@DataProvider(name = "yamlDataProvider3")
	public static Object[][] yamlDataProvider3() throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(filePath + "mapData.yaml");
		SeLionDataProvider seLionDataProvider = DataProviderFactory.getDataProvider(fileSystemResource);
		return seLionDataProvider.getAllData();
	}
	
	@DataProvider(name = "yamlDataProvider4") 
	public static Object[][] yamlDataProvider4() throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(filePath + "mapData.yaml");
		SeLionDataProvider seLionDataProvider = DataProviderFactory.getDataProvider(fileSystemResource);
		String[] keys = {"test2"};
		return seLionDataProvider.getDataByKeys(keys);
	}
	


}
