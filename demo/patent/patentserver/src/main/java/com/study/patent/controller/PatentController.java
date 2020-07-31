package com.study.patent.controller;

import com.study.patent.domain.Condition;
import com.study.patent.domain.Patent;
import com.study.patent.repositories.patentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PatentController {

    @Autowired
    private patentRepository repository;

    public void testQueryPatent(Patent patent) {
        String province1 = patent.getProvince();
        int invent = patent.getInvent();
        int practical = patent.getPractical();
        int aspect = patent.getAspect();
        int total = patent.getTotal();

        System.out.println("省份：" + province1);
        System.out.println("发明：" + invent);
        System.out.println("实用：" + practical);
        System.out.println("外观：" + aspect);
        System.out.println("总计：" + total);
    }

    @PostMapping(value = "/hello")
    public Patent pathentAll(@RequestBody Condition condition)
    {
        System.out.println("参数是：" +  condition.getYear());
        System.out.println("参数是：" +  condition.getCategory());
        System.out.println("参数是：" +  condition.getContent());
        System.out.println("参数是：" +  condition.getProvince());


        if(condition.getYear().equals("2011") && condition.getContent().equals("申请量")){
            Patent patent = repository.queryFrom11Apply(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2011") && condition.getContent().equals("授予量")){
            Patent patent = repository.queryFrom11Grant(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2012") && condition.getContent().equals("申请量")){
            Patent patent = repository.queryFrom12Apply(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2012") && condition.getContent().equals("授予量")){
            Patent patent = repository.queryFrom12Grant(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2013") && condition.getContent().equals("申请量")){
            Patent patent = repository.queryFrom13Apply(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2013") && condition.getContent().equals("授予量")){
            Patent patent = repository.queryFrom13Grant(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2014") && condition.getContent().equals("申请量")){
            Patent patent = repository.queryFrom14Apply(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2014") && condition.getContent().equals("授予量")){
            Patent patent = repository.queryFrom14Grant(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2015") && condition.getContent().equals("申请量")){
            Patent patent = repository.queryFrom15Apply(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        if(condition.getYear().equals("2015") && condition.getContent().equals("授予量")){
            Patent patent = repository.queryFrom15Grant(condition.getProvince());
            testQueryPatent(patent);
            return patent;
        }

        return null;

    }
}
