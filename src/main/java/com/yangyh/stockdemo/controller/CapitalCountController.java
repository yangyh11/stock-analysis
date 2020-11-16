package com.yangyh.stockdemo.controller;

import com.yangyh.stockdemo.service.CapitalStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yangyh
 * @create: 2020-08-06 01:31
 */
@RestController
@RequestMapping("/capital")
public class CapitalCountController {

    @Autowired
    private CapitalStockService capitalStockService;

    /**
     * 127.0.0.1:8080/capital/saveCapitalInfo
     * @return
     */
    @RequestMapping("saveCapitalInfo")
    public String saveCapitalInfo(){
        capitalStockService.saveCapitalInfo();
        return "success";

    }

    @RequestMapping("addStock")
    public String addStock(){
        capitalStockService.addStock();
        return "success";

    }
    @RequestMapping("reductionStock")
    public String reductionStock(){
        capitalStockService.reductionStock();
        return "success";
    }

    /**
     * 127.0.0.1:8080/capital/holdStock
     * @return
     */
    @RequestMapping("holdStock")
    public String holdStock(){
        capitalStockService.holdStock();
        return "success";
    }

    /**
     * 127.0.0.1:8080/capital/top40CapitalHoldStock
     * @return
     */
    @RequestMapping("top40CapitalHoldStock")
    public String getTop40Capital(){
        capitalStockService.top40CapitalHoldStock();
        return "success";
    }
}
