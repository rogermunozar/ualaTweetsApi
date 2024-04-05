package test.infrastructure;

import java.io.File;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/test")
public class TestEmuleController {

    @GetMapping()
    public String getFollows() {            
        //File jsonFollows = new File("follows1.json");        
        return "HOLA";//jsonFollows.toString();        
    }
    

}
