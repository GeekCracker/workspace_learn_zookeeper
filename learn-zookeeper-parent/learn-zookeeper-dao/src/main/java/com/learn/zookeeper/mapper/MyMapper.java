package com.learn.zookeeper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.zookeeper.domain.entity.BaseEntity;

public interface MyMapper<T extends BaseEntity> extends BaseMapper<T> {
}
