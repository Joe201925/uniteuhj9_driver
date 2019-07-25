package com.qf.service;

import com.qf.bean.Users;

public interface UsersServive {

    Users findByUsername(String username);
}
