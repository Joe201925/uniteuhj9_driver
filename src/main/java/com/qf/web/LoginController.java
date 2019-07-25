package com.qf.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    /**
     * 处理登录失败的结果
     *
     */
    @RequestMapping("/tologin")
    public String loginerror(HttpServletRequest request) throws Exception{
        //1.先得到错误信息
        String shiroLoginFailure = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("shiroLoginFailure="+shiroLoginFailure);
        if(shiroLoginFailure!=null){
            if(shiroLoginFailure.equals(UnknownAccountException.class.getName())){
                throw new Exception("用户名有误");
            }else if(shiroLoginFailure.equals(IncorrectCredentialsException.class.getName())) {
                throw new Exception("密码有误");
            }else{
                throw new Exception("其他异常");
            }
        }
        return "login";
    }

    /**
     *退出
     */
    @RequestMapping("/loginout")
    public String loginout(){
        System.out.println("loginout-----------");
        return "login";
    }


}
