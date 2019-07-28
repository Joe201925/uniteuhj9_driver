package com.qf.service.impl;

import com.qf.bean.Users;
import com.qf.dao.UsersMapper;
import com.qf.service.UsersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {

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
