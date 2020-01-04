package com.learn.zookeeper.front.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.zookeeper.domain.entity.User;
import com.learn.zookeeper.domain.response.ResponseResult;
import com.learn.zookeeper.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("AdminUserController")
@RequestMapping("/front/user")
public class UserController extends BaseController<UserService, User> {

    @Reference(version = "0.0.1")
    UserService userService;

    @Override
    public ResponseResult queryData(HttpServletRequest request) {
        return super.queryData(request);
    }

    @Override
    protected IService<User> getService() {
        return userService;
    }
}
