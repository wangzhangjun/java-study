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
