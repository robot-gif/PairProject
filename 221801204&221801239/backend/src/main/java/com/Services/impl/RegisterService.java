package com.Services.impl;

import com.Services.IRegisterService;
import com.mapper.RegisterMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements IRegisterService
{
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int Register(String username, String password)
    {
        List<User> userList;
        userList=registerMapper.getUserByName(username);
        if (userList !=null)
        {
            return -1;//注册失败
        }

        /* else
        {
           registerMapper.addUser(username,password);
           return 1;//注册成功
        } */
        return 0;
    }
}
