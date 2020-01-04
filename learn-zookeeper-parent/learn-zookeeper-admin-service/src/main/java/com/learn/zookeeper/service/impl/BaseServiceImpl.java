package com.learn.zookeeper.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.zookeeper.domain.entity.BaseEntity;

/**
 * Service实现基类
 * @param <M>  当前Mapper
 * @param <T>  当前实体
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>,T extends BaseEntity> extends ServiceImpl<M,T> {
}