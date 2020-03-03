package com.etc.controller;

import com.etc.entity.User;
import com.etc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/userlogin")
    public ModelAndView login(User u, HttpSession session){
        logger.debug("执行登陆：" + u);
        ModelAndView mv = new ModelAndView("sysindex");
        User ru = userService.loginquery(u);
        if(ru != null){
            session.setAttribute("user",ru);
        }else{
            mv.addObject("error","用户名或密码错误!");
            mv.setViewName("login");
        }
        return mv;
    }
}
