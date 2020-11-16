package com.yangyh.stockdemo.mapper;

import com.yangyh.stockdemo.entity.CapitalStockAddEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-8-11 23:49:24
 */
@Repository
public interface CapitalStockAddMapper {

    List<CapitalStockAddEntity> queryByMap(Map<String, Object> map);

    void save(CapitalStockAddEntity entity);

    void update(CapitalStockAddEntity entity);

}