package com.amazon.utility;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static  String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{

		String[][] arrayExcelData = null;
    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook workbook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    workbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

        workbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet sheet = workbook.getSheet(sheetName);
    // row count
    int rowCount=sheet.getLastRowNum()+1;
    //column count
    Row row=sheet.getRow(0);
    int colCount=row.getLastCellNum();
    
    //define size
    arrayExcelData=new String[rowCount-1][colCount];
    
    for (int i = 1; i < rowCount; i++) {

        Row row1 = sheet.getRow(i);

        //Create a loop to print cell values in a row

        for (int j = 0; j < row1.getLastCellNum(); j++) {

            //Print Excel data in console

        	
        	 if(row1.getCell(j).getCellType()==(row1.getCell(j).getCellType().STRING))//checks for string 
 			{
        		 arrayExcelData[i-1][j]= row1.getCell(j).getStringCellValue();
        		 //System.out.print(row1.getCell(j).getStringCellValue()+"\t");
             
 			}
 			else//if value is not string
 			{
 				
 				arrayExcelData[i-1][j]= NumberToTextConverter.toText(row1.getCell(j).getNumericCellValue());
 				//System.out.print(NumberToTextConverter.toText(row1.getCell(j).getNumericCellValue())+"\t");
 			}

        }
        //System.out.println("");

       
    } 

  
return arrayExcelData;
    
    }  
	
	/*public static void main(String args[]) throws IOException
	{
		readExcel("C:\\Users\\saiha\\Documents","Demodata.xlsx","UP");
		
	}*/



}