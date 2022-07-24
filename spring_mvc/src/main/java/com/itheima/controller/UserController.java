package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserController
 * @author: mafangnian
 * @date: 2022/4/16 18:53
 * @Blog: null
 */

@Controller
@RequestMapping("/user")
public class UserController {



    //MultipartFile 会上传的文件封装成一个对象
    @RequestMapping("/quick22")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save22(String username, MultipartFile[] upload) throws IOException {
        System.out.println(username);
        for (int i = 0;i<upload.length;i++){
            //获得文件名称
            String originalFilename = upload[i].getOriginalFilename();
            //将文件另存为本机新建文件下
            upload[i].transferTo(new File("D:\\upload\\"+originalFilename));
        }
    }


    @RequestMapping("/quick21")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save21(@CookieValue(value = "JSESSIONID",required = false) String jsessionID) throws IOException {
        System.out.println(jsessionID);
    }

    @RequestMapping("/quick20")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    //获得servlet对应的API 使用参数注入的方法即可
    @RequestMapping("/quick19")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick18")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save18(Date date) throws IOException {
        System.out.println(date);
        //打印zhangsan
    }

    //获得Restful风格的参数
    //访问地址:localhost:8080/user/quick17/zhangsan
    @RequestMapping("/quick17/{username}")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save17(@PathVariable("username") String username) throws IOException {
        System.out.println(username);
        //打印zhangsan
    }

    @RequestMapping("/quick16")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save16(@RequestParam(value = "name", required = false) String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping("/quick15")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    @RequestMapping("/quick14")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping("/quick13")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save13(String[] str) throws IOException {
        System.out.println(Arrays.asList(str));
    }

    @RequestMapping("/quick12")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    @RequestMapping("/quick11")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public void save11(String username, int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick10")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    //期望SpringMVC将user转换成JSON格式的字符串格式返回
    public User save10() throws IOException {
        User user = new User();
        user.setName("lisi");
        user.setAddr("nmmdw");
        user.setAge(30);

        return user;
    }

    @RequestMapping("/quick9")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public String save9() throws IOException {
        User user = new User();
        user.setName("lisi");
        user.setAge(30);
        //使用JSON的转换工具将对象转换成JSON格式的字符串返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping("/quick8")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping("/quick7")
    @ResponseBody   //告知SpringMVC框架该方法不进行视图跳转 直接进行数据响应
    public String save7() throws IOException {
        return "hello,heima·";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello,heima");
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        /*
            Model:模型 作用封装数据
         */
        request.setAttribute("username", "MBM");

        return "/success.jsp";
    }

    @RequestMapping("/quick4")
    public String save4(Model model) {
        /*
            Model:模型 作用封装数据
         */
        model.addAttribute("username", "MsM");

        return "/success.jsp";
    }

    /**
     * 传参的modelAndView spring发现需要为它传递参数
     * 从而在spring容器里拿出modelAndView 传递过来
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        /*
            Model:模型 作用封装数据
            View: 视图 作用参数数据
         */
        //添加模型数据
        modelAndView.addObject("username", "MVM");
        //设置视图名称
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        /*
            Model:模型 作用封装数据
            View: 视图 作用参数数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("username", "itcast");
        //设置视图名称
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    //请求地址 http://localhost:8080/user/quick
    @RequestMapping("/quick")
    public String save() {
        System.out.println("controller save running....");
        //转发默认省略了forward
        // forward:/success.jsp
        //重定向默认省略了redirect
        // redirect:/success.jsp
        return "/success.jsp";
    }
}
