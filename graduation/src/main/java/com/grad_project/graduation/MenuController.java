package com.grad_project.graduation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

//Controller
@Controller
@EnableAutoConfiguration
public class MenuController {
    /*
    @RequestMapping(value = "/food/order", method = RequestMethod.GET) //HTTP URI에 적는 부분
    public String newOrder(Model model) {
        model.addAttribute("order", new Client());  //객체 찾기
        return "regMember";  //해당 웹페이지로의 리턴
    }
    */
}
