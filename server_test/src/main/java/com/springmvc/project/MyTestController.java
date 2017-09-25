package com.springmvc.project;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win 10 on 2017/9/25.
 */
@Controller
@RequestMapping(value = "/test")
public class MyTestController {

    @RequestMapping(value = "list")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("hell controller");
    }

    @RequestMapping(value = "create")
    public String create(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return "create";
    }

    @RequestMapping(value = "save")
    public String save(HttpServletRequest request, HttpServletResponse response, Model model, User user) {
        model.addAttribute("user", user);
        return "detail";
    }
}
