package com.alibou.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MySecondService {

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return "Java Version : "+environment.getProperty("java.version");
    }

    public String getOsName() {
        return "OS Name : "+environment.getProperty("os.name");
    }
}
