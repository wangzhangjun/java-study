package com.study.excelimport;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class testExcel {


    public void testReadExcel() throws Exception{


        FileInputStream fis = new FileInputStream("/Users/zhjwang/Study/springboot/excelimport/src/main/resources/test.xlsx");
        OPCPackage pkg = OPCPackage.open(fis);

        //excel文件
        XSSFWorkbook wb = new XSSFWorkbook(pkg);

        //Excel工作表
        XSSFSheet sheet = wb.getSheetAt(0);

        //表头的哪一行
        XSSFRow titleRow = sheet.getRow(0);

        //表头那个单元格
        XSSFCell titleCell = titleRow.getCell(0);
        String title = titleCell.getStringCellValue();

        System.out.println("标题是："+title);
    }

}
