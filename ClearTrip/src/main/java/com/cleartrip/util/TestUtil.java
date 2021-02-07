package com.cleartrip.util;

import java.util.ArrayList;

import com.cleartrip.base.BaseClass;


public class TestUtil extends BaseClass {
	
	
	public static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("D:/workspace/ClearTrip/testData/ClearTrip.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
			String deparatureCity = reader.getCellData("Sheet1", "departureCity", rowNum);
			String arrivalCity = reader.getCellData("Sheet1", "arrivalCity", rowNum);
			Object ob[] = {deparatureCity, arrivalCity};
			myData.add(ob);

		}
		return myData;



	}
}
