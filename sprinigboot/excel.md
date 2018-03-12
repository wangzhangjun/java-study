# springboot实现excel导入

 ### 1.导入依赖
 ```
 group 'com.study.excelimport'
version '1.0-SNAPSHOT'

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.6.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'

sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    compile "org.springframework.boot:spring-boot-starter-web"
    compile group: 'org.apache.tomcat.embed', name: 'tomcat-embed-jasper', version: '9.0.0.M26'
    compile group: 'org.apache.poi', name: 'poi', version: '3.9'
    compile group: 'org.apache.poi', name: 'poi-ooxml', version: '3.9'
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

 ```

 ### 2.
 ```
 package com.study.excelimport;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = run(App.class, args);

        try {
            context.getBean(testExcel.class).testReadExcel();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

 ```

 ### 3.
 ```
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

 ```
