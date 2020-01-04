package com.learn.zookeeper.service.impl;

import com.learn.zookeeper.domain.entity.User;
import com.learn.zookeeper.mapper.UserMapper;
import com.learn.zookeeper.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "0.0.1")
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
}
