package com.example.httpclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/get")
    public String get() throws InterruptedException {
        return "get无参请求成功";
    }

    @GetMapping("/getWithHead")
    public String getWithHead() {
        return "get带请求头请求成功,参数message: " + request.getHeader("name");
    }

    @GetMapping("/getWithParam")
    public String getWithParam(@RequestParam String message) {
        return "get带参请求成功,参数message: " + message;
    }


    @PostMapping("/post")
    public String post() {
        return "post无参请求成功";
    }

    @PostMapping("/postWithHead")
    public String post(@RequestHeader("name") String name) {
        System.out.println("Cookie = " + name);
        return "post无参请求成功";
    }

    @PostMapping("/postWithParam")
    public String postWithParam(@RequestParam String code) {
        return "post带参请求成功,参数code: " + code;
    }

}
