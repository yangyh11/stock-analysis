package com.yangyh.stockdemo.service;

import com.yangyh.stockdemo.entity.CapitalInfoEntity;

import java.util.Map;

/**
 * @description:
 * @author: yangyh
 * @create: 2020-08-06 01:30
 */
public interface CapitalStockService {

    /**
     * 机构详情
     */
    void saveCapitalInfo();


    /**
     * 机构新建仓股票
     */
    void buildStock();

    /**
     * 机构加仓股票
     */
    void addStock();

    /**
     * 机构减仓股票
     */
    void reductionStock();

    /**
     * 机构持仓股票
     */
    void holdStock();

    Map<String, CapitalInfoEntity> getTop40Capital();

    void top40CapitalHoldStock();
}
