package com.learn.zookeeper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.zookeeper.domain.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> extends IService<T> {
}
