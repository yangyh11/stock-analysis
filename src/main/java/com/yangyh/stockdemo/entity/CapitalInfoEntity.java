package com.yangyh.stockdemo.entity;

import java.io.Serializable;
    import java.lang.Double;
    import java.lang.String;
    import java.lang.Integer;

/**
* @description:
* @author: Administrator
* @create: 2020-8-16 16:40:45
*/
public class CapitalInfoEntity implements Serializable {

private static final long serialVersionUID = 1L;

    private Integer id;
    private String brokercode;
    private String brokername;
    private String tradeday;
    private Double allamount;
    private Double marketvalue;
    private Double profitlossrate;
    private Integer count;
    private Integer newnum;
    private Integer increasenum;
    private Integer decreasenum;
    private Integer continuousdays;
    private Integer holdrate;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public String getBrokercode() {
    return brokercode;
    }

    public void setBrokercode(String brokercode) {
    this.brokercode = brokercode;
    }
    public String getBrokername() {
    return brokername;
    }

    public void setBrokername(String brokername) {
    this.brokername = brokername;
    }
    public String getTradeday() {
    return tradeday;
    }

    public void setTradeday(String tradeday) {
    this.tradeday = tradeday;
    }
    public Double getAllamount() {
    return allamount;
    }

    public void setAllamount(Double allamount) {
    this.allamount = allamount;
    }
    public Double getMarketvalue() {
    return marketvalue;
    }

    public void setMarketvalue(Double marketvalue) {
    this.marketvalue = marketvalue;
    }
    public Double getProfitlossrate() {
    return profitlossrate;
    }

    public void setProfitlossrate(Double profitlossrate) {
    this.profitlossrate = profitlossrate;
    }
    public Integer getCount() {
    return count;
    }

    public void setCount(Integer count) {
    this.count = count;
    }
    public Integer getNewnum() {
    return newnum;
    }

    public void setNewnum(Integer newnum) {
    this.newnum = newnum;
    }
    public Integer getIncreasenum() {
    return increasenum;
    }

    public void setIncreasenum(Integer increasenum) {
    this.increasenum = increasenum;
    }
    public Integer getDecreasenum() {
    return decreasenum;
    }

    public void setDecreasenum(Integer decreasenum) {
    this.decreasenum = decreasenum;
    }
    public Integer getContinuousdays() {
    return continuousdays;
    }

    public void setContinuousdays(Integer continuousdays) {
    this.continuousdays = continuousdays;
    }
    public Integer getHoldrate() {
    return holdrate;
    }

    public void setHoldrate(Integer holdrate) {
    this.holdrate = holdrate;
    }

}