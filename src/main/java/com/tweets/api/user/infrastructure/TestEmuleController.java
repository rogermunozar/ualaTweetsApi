package com.tweets.api.user.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/test")
public class TestEmuleController {

    @Autowired
    private ResourceLoader resourceLoader;
    
    @GetMapping()
    public String getFollows() {            
        String json="";
        try{
            File jsonFollowsFile = resourceLoader.getResource("classpath:follows1.json").getFile();
	        Scanner myReader = new Scanner(jsonFollowsFile);
            while (myReader.hasNextLine()) {
            json += myReader.nextLine();                    
            }        
        }catch(Exception e){
            json=e.getMessage();
            json+="\n"+System.getProperty("user.dir");
        }
        return json;
    }
    

}
