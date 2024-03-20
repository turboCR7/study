package com.lmj.config;

import com.lmj.pojo.User;
import com.lmj.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//管理员的拦截器
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private UserServiceImpl userService;

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一个项目对于登陆的实现逻辑都有所区别，这里使用最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
        // Session的过期时间为300秒（5分钟）
        session.setMaxInactiveInterval(300);

        //如果session中没有user，表示没登陆
        if (session.getAttribute("username") == null || session.getAttribute("userRole") == null){
            response.sendRedirect("/toLogin");
            return false;
        }

        //这里的User是登陆时放入session的
        String username = session.getAttribute("username").toString();
        String userRole = session.getAttribute("userRole").toString();

        User user = userService.queryUserByUsername(username);
        if (Integer.parseInt(userRole) == user.getRoleId()){
            return true;
        }
        //当前不满足条件,直接跳转拦截
        response.sendRedirect("/toLogin");
        return false;
    }

}
