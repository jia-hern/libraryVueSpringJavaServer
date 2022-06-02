package com.example.springbootbook.service;

import com.example.springbootbook.model.User;

/**
 * @author sa
 * @date 19.09.2021
 * @time 16:47
 */
public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
