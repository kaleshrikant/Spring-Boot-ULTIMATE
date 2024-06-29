package com.alibou.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources( {
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:system-details.properties")
})
public class MySecondService {

    private Environment environment;

    @Value("${system.user.name}")
    private String userName;


    @Value("${system.OS}")
    private String system_OS;
    @Value("${system.Kernel}")
    private String system_Kernel;
    @Value("${system.Terminal}")
    private String system_Terminal;

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

    public String readProps() {
        return "Application Name : "+environment.getProperty("spring.application.name");
    }

    public String getUserName() {
        return "User Name : "+userName;
    }

    public String getSystemDetails() {
        return "OS Name : "+system_OS + "\nKernel Version : "+system_Kernel + "\nTerminal : "+system_Terminal;
    }
}
