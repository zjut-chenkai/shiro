package org.com.zjut.ie.ck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
    	System.out.println("IndexController-----------index");
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
    	System.out.println("IndexController----------welcome");
        return "welcome";
    }


}
