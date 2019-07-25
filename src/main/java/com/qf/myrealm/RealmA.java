package com.qf.myrealm;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.qf.bean.Users;
import com.qf.service.UsersServive;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class RealmA extends AuthorizingRealm {

    @Resource
    private UsersServive usersServive;

    /**
     * 认证用户登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("开始认证");

         //1.得到用户姓名
        String  username = (String) authenticationToken.getPrincipal();

        //2.调用service层方法进行查询
        Users user = usersServive.findByUsername(username);
       if (user==null){
           return null;
       }

       //3.判断密码
        String pass = (String) authenticationToken.getCredentials();
        if (pass!=user.getPassword()){
            return null;
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username,user.getPassword(),"RealmA");

        return info;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        return null;
    }


}
