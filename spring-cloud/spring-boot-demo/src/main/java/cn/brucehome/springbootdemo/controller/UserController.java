package cn.brucehome.springbootdemo.controller;

import cn.brucehome.springbootdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public Object getUsers(){
        User user = new User();
        user.setUid("1");
        user.setUname("bruce");
        user.setPwd("123456");
        return user;
    }
}
