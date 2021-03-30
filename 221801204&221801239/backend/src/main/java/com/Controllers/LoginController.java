package com.Controllers;

import com.Services.ILoginService;
import com.Services.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    @Autowired
    private ILoginService loginService;

    @RequestMapping("/login")
    public int Login(String username,String password)
    {
        return loginService.Login(username, password);
    }


}
