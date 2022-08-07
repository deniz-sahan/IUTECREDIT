package com.factorial.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadData {
    @DataProvider(name = "factoryTestData")
    public Object[][] datas() throws IOException {
    	
        //String path = System.getProperty("user.dir") + "\\TestData\\" + DataFileName; // excel dosya path'i
        String path = "C:\\Users\\deniz\\Documents\\IUTECREDIT\\TestData\\factorialTesData.xlsx";
    	XLUtility xlutil = new XLUtility(path);
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1",1);
        Object[][] inputNumbers = new String[totalrows][totalcols];
        for (int i=1; i<=totalrows; i++){ // Buradaki i değişkeni okumaya başlamak istediğimiz satırdır.
            for (int j=0; j<totalcols; j++){
            	inputNumbers[i-1][j]=xlutil.gellCellData("Sheet1",i,j); // i-1 kısmı ise başlangıçta 0'a eşit olmalıdır. Yani i=5 için i-5 olmalı.
            }
        }

        return inputNumbers;
    }
}
