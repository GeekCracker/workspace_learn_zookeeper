package com.learn.zookeeper.admin.controller;

import com.learn.zookeeper.domain.entity.User;
import com.learn.zookeeper.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
public class UserController extends BaseController<UserService, User> {
}
