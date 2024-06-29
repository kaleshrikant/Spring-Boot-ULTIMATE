package com.alibou.example.service;

import com.alibou.example.bean.MyFirstClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    // @Autowired
    public MyFirstService(
            @Qualifier("bean-2") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory() {
        return "the dependency says.." +myFirstClass.sayHello();
    }
}
