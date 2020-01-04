package com.learn.zookeeper.front.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.zookeeper.domain.entity.BaseEntity;
import com.learn.zookeeper.domain.response.ResponseResult;
import com.learn.zookeeper.service.BaseService;
import com.learn.zookeeper.utils.GenericsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseController<S extends BaseService,T extends BaseEntity> {

    @Autowired
    protected ConfigurableApplicationContext applicationContext;

    /**
     * 获取当前Service
     * @return 返回当前Service
     */
    protected IService<T> getService(){return (IService<T>)applicationContext.getBean(GenericsUtils.getSuperClassGenricType(this.getClass(),0));}

    /**当前实体类class对象*/
    protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());

    /**
     * 增加或修改
     * @param entity 传入需要添加或修改的实体
     * @return 返回操作信息
     */
    @RequestMapping("save")
    public ResponseResult save(T entity){
        return ResponseResult.ok(getService().saveOrUpdate(entity));
    }
    /**
     * 根据ID查询
     * @param id 传入ID
     * @return 返回结果
     */
    @RequestMapping("queryById")
    public ResponseResult queryById(Long id){
        return ResponseResult.ok(getService().getById(id));
    }

    /**
     * 根据ID删除
     * @param id 传入ID
     * @return 返回操作信息
     */
    @RequestMapping("deleteById")
    public ResponseResult deleteById(Long id){
        return ResponseResult.ok(getService().removeById(id));
    }

    /**
     * 查询数据列表（不带分页）
     * @param request 传入request请求
     * @return 返回数据列表
     */
    @RequestMapping("queryData")
    public ResponseResult queryData(HttpServletRequest request){
        Wrapper<T> wrapper = getQueryWrapper(request);
        System.out.println("+++++++");
        System.out.println(wrapper);
        return ResponseResult.ok(getService().list(wrapper));
    }


    /**
     * 查询数据列表（带分页）
     * @param pageNum 当前页
     * @param pageSize 每页显示数据条数
     * @param request 传入request请求
     * @return 返回分页数据
     */
    @RequestMapping("queryPageData")
    public ResponseResult queryPageData(@RequestParam(defaultValue = "1") Long pageNum, @RequestParam(defaultValue = "10") Long pageSize, HttpServletRequest request){
        return ResponseResult.ok(getService().page(new Page<T>(pageNum,pageSize),getQueryWrapper(request)));
    }

    /**
     * 根据请求获取请求条件
     * @param request 传入request请求
     * @return 返回请求条件
     */
    protected Wrapper<T> getQueryWrapper(HttpServletRequest request){
        return new QueryWrapper(JSONObject.parseObject(JSONObject.toJSONString(getQueryParam(request)),this.entityClass));
    }

    /**
     * 根据请求获取请求条件
     * @param request 传入request请求
     * @return 返回请求条件
     */
    protected Map<String,Object> getQueryParam(HttpServletRequest request){
        //组装查询条件
        Map<String,Object> map = new LinkedHashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            String value = request.getParameter(paramName);
            if(StringUtils.isNotBlank(value)){
                map.put(paramName,value);
            }
        }
        return map;
    }

}
