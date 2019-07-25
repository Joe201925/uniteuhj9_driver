package com.qf.dao;

import com.qf.bean.Users;

public interface UsersMapper {

    Users findByUsername(String username);

}
