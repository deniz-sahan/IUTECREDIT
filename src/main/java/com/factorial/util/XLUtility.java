package com.factorial.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	 public FileInputStream fi;
	    public XSSFWorkbook workbook;
	    public XSSFSheet sheet;
	    public XSSFRow row;
	    public XSSFCell cell;
	    String path;
	    XLUtility(String path){
	        this.path = path;
	    }

	    public int getRowCount(String sheetName) throws IOException{
	        fi=new FileInputStream(path);  //Dosyaya eriştiğimiz kısım
	        workbook=new XSSFWorkbook(fi); //Dosyayı workbook olarak okuyoruz
	        sheet=workbook.getSheet(sheetName);//Workbook'taki sheet'e erişme
	        int rowcount=sheet.getLastRowNum();
	        workbook.close();
	        fi.close();
	        return rowcount;
	    }

	    public int getCellCount(String sheetName, int rowNum) throws IOException{
	        fi=new FileInputStream(path);
	        workbook=new XSSFWorkbook(fi);
	        sheet=workbook.getSheet(sheetName);
	        row=sheet.getRow(rowNum);
	        int cellcount=row.getLastCellNum(); //Bir satırdaki sütun sayısını alıyoruz
	        workbook.close();
	        fi.close();
	        return cellcount;
	    }

	    public String gellCellData(String sheetName, int rowNum, int colNum) throws IOException{
	        fi=new FileInputStream(path);
	        workbook=new XSSFWorkbook(fi);
	        sheet=workbook.getSheet(sheetName);
	        row=sheet.getRow(rowNum);
	        cell=row.getCell(colNum);

	        DataFormatter formatter = new DataFormatter();
	        String data;
	        try{
	            data = formatter.formatCellValue(cell); 
	        }
	        catch(Exception e)
	        {
	            data="";
	        }
	        workbook.close();
	        fi.close();
	        return data;
	    }

}
