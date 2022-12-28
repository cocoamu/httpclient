package com.example.httpclient;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class HttpClientUtil2Test {

    /**
     * Description: 测试get无参请求
     *
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        HttpResult result = HttpClientUtil2.doGet("http://127.0.0.1:8080/hello/get");
        System.out.println(result);
    }

    /**
     * Description: 测试get带head请求
     *
     * @throws Exception
     */
    @Test
    public void testGetWithHead() throws Exception {
        Map<String, String> head = new HashMap<String, String>();
        head.put("name", "key");
        HttpResult result = HttpClientUtil2.doGet("http://127.0.0.1:8080/hello/getWithHead",null,head);
        System.out.println(result);
    }

    /**
     * Description: 测试get带参请求
     *
     * @throws Exception
     */
    @Test
    public void testGetWithParam() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("message", "key");
        HttpResult result = HttpClientUtil2.doGet("http://127.0.0.1:8080/hello/getWithParam", params);
        System.out.println(result);
    }


    /**
     * Description: 测试post带请求头不带请求参数
     *
     * @throws Exception
     */
    @Test
    public void testPost() throws Exception {
        HttpResult result = HttpClientUtil2.doPost("http://127.0.0.1:8080/hello/post", null, null);
        System.out.println(result);
    }

    /**
     * Description: 测试post带请求头不带请求参数
     *
     * @throws Exception
     */
    @Test
    public void testPostWithHead() throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("name", "123");
        HttpResult result = HttpClientUtil2.doPost("http://127.0.0.1:8080/hello/postWithHead", null,headers );
        System.out.println(result);
    }

    /**
     * Description: 测试post带参请求
     *
     * @throws Exception
     */
    @Test
    public void testPostWithParam() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", "001");
        HttpResult result = HttpClientUtil2.doPost("http://127.0.0.1:8080/hello/postWithParam", params);
        System.out.println(result);
    }

}
