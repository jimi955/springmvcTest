package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})   // 把msg=美美存入到session域对中
public class AnnoController {

    // 当请求参数名和业务函数的参数不同的时候  需要使用@RequestParam(name="name")指定name赋值username  此时请求参数名称必须为name 否则失败
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     *
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     *
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     *
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行了...");
        System.out.println(header);
        // return "success";
        // response.sendRedirect(request.getContextPath()+"/anno/testCookieValue");
        return "redirect:/param.jsp";
    }


    /**
     * 获取Cookie的值
     *
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     *
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
//    public String testModelAttribute(@ModelAttribute() User user) {
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute执行了...");
        // 最终的user是客户端传过来的user信息
        System.out.println(user);
        return "success";
    }

    //    @ModelAttribute
    public User showUser(String uname) {
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        // uname和age会被客户端传来的user.name和user.age覆盖掉
        user.setUname("ss");
        user.setAge(20);
        // 客户端没有的值  user使用user中的数据
        user.setDate(new Date());
        return user;
    }

    @ModelAttribute
    public void showUser2(String uname, Map<String, User> map) {
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * SessionAttributes的注解
     *
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        model.addAttribute("msg", "美美");
        return "success";
    }

    /**
     * 获取值
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     *
     * @param status
     * @return
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("getSessionAttributes...");
        // 表示操作完成  会清空session
        status.setComplete();
        return "success";
    }

}














