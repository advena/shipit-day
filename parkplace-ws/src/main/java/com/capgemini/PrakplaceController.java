package com.capgemini;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrakplaceController {


    
    @RequestMapping("/freeParkplaces")
    public Parkplaces freeParkplaces() {
        return new Parkplaces(1, new Date());
    }
}
