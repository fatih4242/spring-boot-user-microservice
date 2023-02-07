package com.fatihtoker.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMetho(){
        return "User Service si taking longer than expected."+
                " Please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMetho(){
        return "Departöent Service is taking longer than expected."+
                " Please try again later";
    }
}
