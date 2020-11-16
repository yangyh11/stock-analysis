package com.yangyh.stockdemo.mapper;

import com.yangyh.stockdemo.entity.CapitalStockNewAddEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-8-11 23:53:48
 */
@Repository
public interface CapitalStockNewAddMapper {

    List<CapitalStockNewAddEntity> queryByMap(Map<String, Object> map);

    void save(CapitalStockNewAddEntity entity);

    void update(CapitalStockNewAddEntity entity);

    int saveBatch(List<CapitalStockNewAddEntity> list);


}