package com.dawn.wiki.controller;

import com.dawn.wiki.domain.Test;
import com.dawn.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

// 用来返回字符串 而@Controller用来返回页面 @ResponseBody用来返回字符串或JSON对象
@RestController
public class TestController {
    // http://127.0.0.1:8080/hello

    // 自定义配置项 优先读配置文件，没有就用默认值
    @Value("${test.hello:Test}")
    private String testHello;

    @Resource
    private TestService testService;

    /**
     * http请求方式：GET, POST, PUT, DELETE
     * @RequestMapping 表示这个接口支持四种请求方式
     * @GetMapping 只支持GET方法 同理 @PostMapping @PutMapping @DeleteMapping
     *
     * /user?id=1
     * /user/1 Restful风格
     * /
     * @return
     */

//    @RequestMapping(value = "/user/1", method = RequestMethod.GET)
//    @RequestMapping(value = "/user/1", method = RequestMethod.DELETE)
    // method 限制可使用的方法

    // 注解的括号内为接口的请求地址
    @GetMapping ("/hello")
    public String hello() {
        return "Hello World!" + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World! Post, " + name;
    }

    @GetMapping ("/test/list")
    public List<Test> list() {
        return testService.list();
    }
}
