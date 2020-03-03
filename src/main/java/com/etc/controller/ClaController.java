package com.etc.controller;

import com.etc.entity.Cla;
import com.etc.service.ClaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ClaController {
    @Resource
    private ClaService claService;

    @RequestMapping("/clatoadd")
    public ModelAndView toadd(){
        ModelAndView mv = new ModelAndView("claadd");
        return mv;
    }

    @RequestMapping("/claadd")
    public ModelAndView add(Cla c, HttpSession session){
        ModelAndView mv = new ModelAndView();
        claService.add(c);
        session.setAttribute("msg","新加成功！");
        mv.setViewName("redirect:claget?cid="+c.getCid());
        return mv;
    }

    @RequestMapping("/clamod")
    public ModelAndView mod(Cla c){
        claService.mod(c);
        ModelAndView mv = new ModelAndView("forward:/claget?cid="+c.getCid());
        mv.addObject("msg","修改成功！");
        return mv;
    }

    @RequestMapping("/claget")
    public ModelAndView get(int cid){
        ModelAndView mv = new ModelAndView("claget");
        mv.addObject("g",claService.get(cid));
        return mv;
    }

    @RequestMapping("/claquery")
    public ModelAndView query(@RequestParam(value = "pageNo",required = true,defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize",required = true,defaultValue = "10") int pageSize){
        ModelAndView mv = new ModelAndView("claquery");
        mv.addObject("p",claService.query(null,pageNo,pageSize));
        return mv;
    }

    @RequestMapping("/cladel")
    public ModelAndView del(int cid){
        claService.del(cid);
        ModelAndView mv = new ModelAndView("forward:/claquery");
        mv.addObject("msg","删除成功！");
        return mv;
    }
}
