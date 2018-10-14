package cn.brucehome.springcloud.eurekaclient.controller;

import cn.brucehome.springcloud.eurekaclient.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Bruce.Z
 * @Email: lunluoren12@qq.com
 * @Date: 2018/10/14 20:07
 * @Version: 1.0
 */
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
