package com.example.demo.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {

    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {

        User user = new User();
        user.setId(1);
        user.setName("Jerry");
        user.setContactEmail("hello@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(user);
        System.out.println("json 的值為： " + jsonResult);

        String json = "{" +
                "\"id\":1," +
                "\"name\":\"Jerry\"," +
                "\"contact_email\":\"world@gmail.com\"}";
        User userResult = objectMapper.readValue(json, User.class);
        System.out.println("User 的 Id 值為： " + userResult.getId());
        System.out.println("User 的 name 值為： " + userResult.getName());
        System.out.println("User 的 contactEmail 值為：" + userResult.getContactEmail());

        return "convert";
    }
}
