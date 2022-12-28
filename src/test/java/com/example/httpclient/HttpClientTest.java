package com.example.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HttpClientTest {

    @Test
    public void testGet() {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            //1、构建HttpClient对象
            httpClient = HttpClients.createDefault();
            //2、创建HttpGet，声明get请求
            HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=java");
            //3、发送请求
            response = httpClient.execute(httpGet);
            //4.判断状态码
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                // 使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
                String string = EntityUtils.toString(entity, "utf-8");
                System.out.println(string);
            }
        } catch (Exception e) {
            // 打印堆栈信息，进行异常情况处理；
        } finally {
            // 5、关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testPost(){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            //1.打开浏览器
            httpClient = HttpClients.createDefault();
            //2.声明get请求
            HttpPost httpPost = new HttpPost("https://www.oschina.net/");
            //3.网站为了防止恶意攻击，在post请求中都限制了浏览器才能访问
            httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
            //4.判断状态码
            List<NameValuePair> parameters = new ArrayList<>(0);
            parameters.add(new BasicNameValuePair("scope", "project"));
            parameters.add(new BasicNameValuePair("q", "java"));

            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
            httpPost.setEntity(formEntity);
            //5.发送请求
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                String string = EntityUtils.toString(entity, "utf-8");
                System.out.println(string);
            }
        } catch (Exception e){
            // 打印堆栈信息，进行异常情况处理；
        } finally {
            // 5、关闭资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
