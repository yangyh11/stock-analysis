package com.yangyh.stockdemo.mapper;

import com.yangyh.stockdemo.entity.CapitalEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* @description:
* @author: Administrator
* @create: 2020-8-16 17:13:07
*/
@Repository
public interface CapitalMapper {

List
<CapitalEntity> queryByMap(Map
    <String
    , Object> map);

    void save(CapitalEntity entity);

    void update(CapitalEntity entity);

    }