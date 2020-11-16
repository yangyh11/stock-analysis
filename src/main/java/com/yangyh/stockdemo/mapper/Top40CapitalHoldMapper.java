package com.yangyh.stockdemo.mapper;

import com.yangyh.stockdemo.entity.CapitalHoldEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-8-11 23:49:24
 */
@Repository
public interface Top40CapitalHoldMapper {

    List<CapitalHoldEntity> queryByMap(Map<String, Object> map);

    void save(CapitalHoldEntity entity);

    void update(CapitalHoldEntity entity);

    int saveBatch(List<CapitalHoldEntity> list);

}