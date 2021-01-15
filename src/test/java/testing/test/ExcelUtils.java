package testing.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	/*Declared a new List Object that holds a collection of HashMaps
	Using the Apache POI functions, I am picking the excel file, navigating to the required sheet
	Declared a Variable of type Row called HeaderRow and hardcoded it to point to row#0, i.e the first row of my excel that has header details aka column names
	Enter the for loop to iterate the rows
	Now, i declared a HashMap object which holds Key and its values in String format
	Why declare HashMap object inside the For loop? Because i want every row of excel data to be saved in a unique HashMap objects
	Enter the for loop to iterate the column
	notice that the “KEY” part of the hashmap always refers to the header row and picks the corresponding column’s cell value
	notice that the “VALUE” part of the hashmap refers the current Row- current column (current as in for loop’s iteration)
	Exit the Column-Iterating for loop
	Add the hashmap into the List object bucket
	Repeat the step4 to 11 as many # of times as the # of rows are there in excel file
	Exit the Row for loop
	Finally, Return the List object*/

	static String filePath = System.getProperty("user.dir")
			+ "\\TestData\\TestData.xlsx";
	static String s3;
	static List <HashMap<String,String>>excelData = new ArrayList<HashMap<String,String>>();
	//public static HashMap<Double,String> storeValues = new HashMap<Double, String>();
	public static List<HashMap<String, String>> readExcelDatafromFile(){
	 
	//create Java List to store Hashmaps
	
		//public static HashMap<String, HashMap<String, String>> excelData = new HashMap<>();
		
	try{
	FileInputStream fs = new FileInputStream(filePath);
	XSSFWorkbook workbook = new XSSFWorkbook(fs);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	Row HeaderRow = sheet.getRow(0);
	for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
		Row currentRow = sheet.getRow(i);
		HashMap<String, String> currentHash = new HashMap<String, String>();
		for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {

			Cell currentCell1 = currentRow.getCell(0);
			switch (currentCell1.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				s3 = currentCell1.getStringCellValue();
				System.out.println(s3);
				break;
			case Cell.CELL_TYPE_NUMERIC:
				s3 = String.valueOf(currentCell1.getNumericCellValue());
				System.out.println(s3);
				break;
			}

			Cell currentCell = currentRow.getCell(j);
			switch (currentCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
						currentCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
						String.valueOf(currentCell.getNumericCellValue()));
				break;
			}

		}
		excelData.add(currentHash);
	}
	//wb.close();
	fs.close();
	}
	catch(Exception e){
	e.printStackTrace();
	}
	 
	return excelData;
}}

