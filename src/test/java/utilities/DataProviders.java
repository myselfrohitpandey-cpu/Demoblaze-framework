package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
	    System.out.println(">> Starting DataProvider");
	    
	    String path = System.getProperty("user.dir") + "\\testdata\\Book1.xlsx";
	    System.out.println(">> Excel Path: " + path);

	    Excelutilities xlutil = new Excelutilities(path);
	    System.out.println(">> Excel Utility initialized");

	    int totalrows = xlutil.getRowCount("Sheet1");
	    System.out.println(">> Total Rows: " + totalrows);

	    int totalcols = xlutil.getCellCount("Sheet1", 1);
	    System.out.println(">> Total Cols: " + totalcols);

	    String[][] logindata = new String[totalrows][totalcols];

	    for (int i = 1; i <= totalrows; i++) {
	        for (int j = 0; j < totalcols; j++) {
	            logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	            System.out.println(">> Cell [" + i + "," + j + "]: " + logindata[i - 1][j]);
	        }
	    }

	    System.out.println(">> Finished reading Excel");
	    return logindata;
	}
}
