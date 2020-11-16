package com.yangyh.stockdemo.mapper;

import com.yangyh.stockdemo.entity.CapitalStockReductionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-8-11 23:49:24
 */
@Repository
public interface CapitalStockReductionMapper {

    List<CapitalStockReductionEntity> queryByMap(Map<String, Object> map);

    void save(CapitalStockReductionEntity entity);

    void update(CapitalStockReductionEntity entity);

}