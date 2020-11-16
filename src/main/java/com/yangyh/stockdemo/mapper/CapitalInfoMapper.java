package com.yangyh.stockdemo.mapper;

import com.yangyh.stockdemo.entity.CapitalInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* @description:
* @author: Administrator
* @create: 2020-8-16 16:40:45
*/
@Repository
public interface CapitalInfoMapper {

    List<CapitalInfoEntity> queryByMap(Map<String, Object> map);

    void save(CapitalInfoEntity entity);

    void update(CapitalInfoEntity entity);

    /**
     * 持有资金量top20的机构
     */
    List<CapitalInfoEntity> getTop20AllMount();

    /**
     * 收益率top20的机构
     */
    List<CapitalInfoEntity>  getTop20ProfitlossrateCapital();

}