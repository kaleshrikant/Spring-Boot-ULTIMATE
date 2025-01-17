package com.alibou.example.service;

import com.alibou.example.bean.MyFirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    // Field Level Injection
   // @Autowired
   // @Qualifier("myThirdBean")
    private MyFirstClass myFirstClass;

    @Autowired
    public void injectDependencies(
           @Qualifier("bean1") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

/*
     // Constructor Injection
    // @Autowired
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
*/

    // Setter Injection
    @Autowired
    public void setMyFirstClass(
          @Qualifier("mySecondBean")  MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "the dependency says.." +myFirstClass.sayHello();
    }
}
