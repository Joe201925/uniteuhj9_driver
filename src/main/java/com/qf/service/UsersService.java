package com.qf.service;

import com.qf.bean.Users;

public interface UsersService {

    Users findByUsername(String username);

}
