package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {
        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        //Step 1. Create excel file object
        //workbook object represent excel file
        //it has spreadsheets that we gonna read as well
        Workbook workbook = WorkbookFactory.create(file);
        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("Number of sheets: " + numOfSheets);

        //step 2.Creat object of spreadsheet
        Sheet sheet = workbook.getSheet("QA3-short");

        //Step 3. Read a row
        Row row1 = sheet.getRow(0);

        //Step 4 . Read cell
        Cell cell1 = row1.getCell(0);
        //Step 5. Extract value
        String value1 = cell1.getStringCellValue();
        //Step 6. Use value
        System.out.println("Value of 1st raw 1st column: " + value1);
        //get all spreadsheet names
        //sh-> temporary variable
        workbook.forEach(sh -> System.out.println(sh.getSheetName()));
        //how do we get a data from entire row
        Iterator<Cell> cellIterator = row1.cellIterator();
        // System.out.println(cellIterator.next().getStringCellValue()+ " ");
        while (cellIterator.hasNext()) {
            String value = cellIterator.next().getStringCellValue();
            System.out.print(value + " ");
        }
        System.out.println("\n##############################################");
        //return iterator of rows
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Iterator<Cell> tempCellIterator = rowIterator.next().cellIterator();
            while (tempCellIterator.hasNext()){
                String value = tempCellIterator.next().getStringCellValue();
                System.out.print(value +" ");
            }
            System.out.println();
        }


    }

}
