package com.yu.demo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yu.demo.dto.LoginDto;
import com.yu.demo.service.HiveJdbcTemplateService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@RequestMapping("")
@Controller
// 这里不使用RestController，用于页面跳转测试
public class JumpController {

    private static final Logger logger = LoggerFactory.getLogger(JumpController.class);

    @Autowired
    private HiveJdbcTemplateService hiveJdbcTemplateService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的test.html")
    public String jumpTest(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "test";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ApiOperation(value = "页面跳转", notes = "测试页面跳转到templates下的home.html")
    public String home(ModelMap map) {
        map.put("username", "小猪佩奇");
        map.put("Message", "yoooo");
        return "home";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的welcome.html")
    public String jumpWelcome(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "welcome";
    }

    @RequestMapping(value = "/portal", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的portal.html")
    public String jumpPortal(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "portal";
    }

    @RequestMapping(value = "/keyWord", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的keyWord.html")
    public String jumpKeyWord(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "keyWord";
    }

    @RequestMapping(value = "/url", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的url.html")
    public String jumpUrl(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "url";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的user.html")
    public String jumpUser(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "user";
    }

    @RequestMapping(value = "/keyWordCloud", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的keyWordCloud.html")
    public String jumpKeyWordCloud(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "keyWordCloud";
    }

    @RequestMapping(value = "/percent", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的percent.html")
    public String jumpPercent(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "percent";
    }

    @RequestMapping(value = "/period", method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的period.html")
    public String jumpPeriod(ModelMap map) {
        map.put("username", "小猪佩奇");
        return "period";
    }

    @RequestMapping(value = {"/anomalyDetection"}, method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的anomalyDetection.html")
    public ModelAndView jumpAnomalyDetection() {
        ModelAndView mv = new ModelAndView("anomalyDetection");
        return mv;
    }

    @RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的login.html")
    public ModelAndView jumpLogin() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping(value = {"/doLogin"}, method = RequestMethod.POST)
    @ApiOperation(value = "登录操作", notes = "登陆，若成功则跳转Portal.html")
    public ModelAndView  jumpToPortal(LoginDto loginDto, HttpServletRequest request, HttpSession session) {

        ModelAndView mav = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        loginDto = hiveJdbcTemplateService.login(loginDto);
        if (loginDto.getCode().equals("YES")) {
            session.setAttribute("loginDto", loginDto);
            mav.setViewName("portal");
            return mav;
        } else {
            session.setAttribute("errormsg", "账号或密码错误!请重新输入");
        }
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping(value = {"/import"}, method = RequestMethod.GET)
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转到templates下的import.html")
    public ModelAndView jumpImport(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView("import");
        session.setAttribute("errormsg", "");
        return mv;
    }

    @RequestMapping(value = {"/doImport"}, method = RequestMethod.POST)
    @ApiOperation(value = "导入操作", notes = "导入操作")
    public ModelAndView doImport(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView("import");

        if(file.isEmpty()){
            session.setAttribute("errormsg", "文件不存在");
            return mv;
        }

        String upLoadDir = "F:/VMShare/";
        String fileName = file.getOriginalFilename();
        //传入sql中的文件位置
        String fileInUbuntu = "VMShare/" + fileName;
        File dest = new File(upLoadDir + fileName);
        try {
            file.transferTo(dest);
            logger.info("文件上传成功");
            String result = hiveJdbcTemplateService.doImport(fileInUbuntu);
            session.setAttribute("errormsg", result);
        } catch (IOException e) {
            logger.error(e.toString(), e);
            session.setAttribute("errormsg", "文件上传失败，请重试");
        }

        return mv;
    }
}
