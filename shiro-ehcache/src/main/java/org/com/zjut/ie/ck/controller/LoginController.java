package org.com.zjut.ie.ck.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login"    )
    public String showLoginForm(HttpServletRequest req, Model model) {
    	System.out.println("LoginController--------------showLoginForm");
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "鐢ㄦ埛鍚�?/瀵嗙爜閿欒";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "鐢ㄦ埛鍚�?/瀵嗙爜閿欒";
        } else if(exceptionClassName != null) {
            error = "鍏朵粬閿欒锛�" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }


}
