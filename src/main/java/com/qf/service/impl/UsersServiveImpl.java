package com.qf.service.impl;

import com.qf.bean.Users;
import com.qf.dao.UsersMapper;
import com.qf.service.UsersServive;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiveImpl implements UsersServive {

    @Resource
    private UsersMapper usersMapper;

    /**
     * 登录功能
     * @param username
     * @return
     */
    @Override
    public Users findByUsername(String username) {

        Users user = usersMapper.findByUsername(username);
        if (user!=null){
            return user;
        }
        return null;
    }
}
