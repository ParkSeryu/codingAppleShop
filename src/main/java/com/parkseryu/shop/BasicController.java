package com.parkseryu.shop;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String test() {
        return "피싱사이트에요";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String myPage() {
        return "마이페이지에요";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        Date today = new Date();
        return "오늘의 날짜는 " + today.toString() + "입니다.";
    }
}
