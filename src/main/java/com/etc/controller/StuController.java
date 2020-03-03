package com.etc.controller;

import com.etc.entity.Stu;
import com.etc.service.ClaService;
import com.etc.service.StuService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class StuController {
    @Resource
    private StuService stuService;
    @Resource
    private ClaService claService;
    private static Logger logger = Logger.getLogger(StuController.class);
    //运行路径
    private String path;
    //开发路径
    private String path2 = "E:\\ideaworkspace2\\mavenprj\\src\\main\\webapp\\pics";

    //初始化方法
    @InitBinder
    public void inital(HttpSession session){
        path = session.getServletContext().getRealPath("/") + "pics/";
        logger.debug(path);
    }
    //此方法用来设置模型中的初值
    @ModelAttribute
    public void setInitialVal(ModelMap mm){
        mm.addAttribute("clist",claService.query());
    }

    @RequestMapping("/stutoadd")
    public ModelAndView toadd(){
        ModelAndView mv = new ModelAndView("stuadd");
        return mv;
    }

    private void savePic(MultipartFile pic,Stu s) throws Exception{
        if(pic != null && pic.getSize() != 0){
            logger.debug("fileName:" + pic.getOriginalFilename());
            String fpath = path + "/" + s.getSid() + ".jpg";
            //保存运行路径
            pic.transferTo(new File(fpath));
            //保存开发路径
            String fpath2 = path2 + "/" + s.getSid() + ".jpg";
            java.io.FileInputStream fis = new java.io.FileInputStream(fpath);
            byte bb[] = new byte[fis.available()];
            fis.read(bb);
            java.io.FileOutputStream fos = new java.io.FileOutputStream(fpath2);
            fos.write(bb);
            fis.close();
            fos.close();
        }
    }

    @RequestMapping("/stuadd")
    public ModelAndView add(Stu s, MultipartFile pic, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView();
        stuService.add(s);
        //保存学生相片
        this.savePic(pic,s);

        mv.setViewName("redirect:stuget/"+s.getSid());
        session.setAttribute("msg","新加成功！");
        return mv;
    }

    @RequestMapping("/stuget/{sid}")
    public ModelAndView get(@PathVariable int sid){
        ModelAndView mv = new ModelAndView("stuget");
        mv.addObject("g",stuService.get(sid));
        return mv;
    }

    @RequestMapping("/studel/{sid}")
    public ModelAndView del(@PathVariable int sid){
        ModelAndView mv = new ModelAndView("forward:/stuquery");
        stuService.del(sid);
        mv.addObject("msg","删除成功！");
        return mv;
    }

    @RequestMapping("/stumod")
    public ModelAndView mod(Stu s,MultipartFile pic) throws Exception{
        ModelAndView mv = new ModelAndView("forward:/stuget/"+s.getSid());
        stuService.mod(s);
        //保存学生相片
        this.savePic(pic,s);
        mv.addObject("msg","修改成功！");
        return mv;
    }

    @RequestMapping("/stuquery")
    public ModelAndView query(Stu s,
                              @RequestParam(value = "pageNo",required = true,defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize",required = true,defaultValue = "10") int pageSize){
        ModelAndView mv = new ModelAndView("stuquery");
        mv.addObject("p",stuService.query(s,pageNo,pageSize));
        return mv;
    }
}
