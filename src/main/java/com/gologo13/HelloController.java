package com.gologo13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String home() {
        return "/home";
    }

    @RequestMapping("/restricted")
    public String restricted() {
        return "restricted";
    }

    @RequestMapping("/admin")
    public String admin() {
        adminService.ensureAdmin();
        return "admin";
    }
}
