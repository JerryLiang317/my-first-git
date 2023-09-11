package com.example.demo.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public String getForObject(){

        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject("https://mocki.io/v1/7b94008f-69a5-47ca-985f-d8d6108aba88", Student.class);

        System.out.println("Student 的 id 值為： " + student.getId());
        System.out.println("Student 的 name 值為： " + student.getName());
        System.out.println("Student 的 phone 值為： " + student.getContactPhone());
        return "getForObject success";
    }
}
