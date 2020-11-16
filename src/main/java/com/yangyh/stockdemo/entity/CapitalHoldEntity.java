package com.yangyh.stockdemo.entity;


import java.io.Serializable;
import java.lang.Long;
import java.lang.Double;
import java.lang.String;
import java.lang.Integer;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-8-11 23:49:24
 */
public class CapitalHoldEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String profitlossrate;
    private Integer holdtrendimgurl;
    private String tradeday;
    private String brokercode;
    private String stockcode;
    private Long marketvalue;
    private Double profitloss;
    private Double percost;
    private Integer isnew;
    private Integer holdnum;
    private Integer changenum;
    private String brokername;
    private Long allamount;
    private Integer continuousday;
    private String changerate;
    private Double allcost;
    private Double holdrate;
    private String industrycode;
    private String industryname;
    private Integer market;
    private String stockname;

    public String getProfitlossrate() {
        return profitlossrate;
    }

    public void setProfitlossrate(String profitlossrate) {
        this.profitlossrate = profitlossrate;
    }

    public Integer getHoldtrendimgurl() {
        return holdtrendimgurl;
    }

    public void setHoldtrendimgurl(Integer holdtrendimgurl) {
        this.holdtrendimgurl = holdtrendimgurl;
    }

    public String getTradeday() {
        return tradeday;
    }

    public void setTradeday(String tradeday) {
        this.tradeday = tradeday;
    }

    public String getBrokercode() {
        return brokercode;
    }

    public void setBrokercode(String brokercode) {
        this.brokercode = brokercode;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public Long getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(Long marketvalue) {
        this.marketvalue = marketvalue;
    }

    public Double getProfitloss() {
        return profitloss;
    }

    public void setProfitloss(Double profitloss) {
        this.profitloss = profitloss;
    }

    public Double getPercost() {
        return percost;
    }

    public void setPercost(Double percost) {
        this.percost = percost;
    }

    public Integer getIsnew() {
        return isnew;
    }

    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    public Integer getHoldnum() {
        return holdnum;
    }

    public void setHoldnum(Integer holdnum) {
        this.holdnum = holdnum;
    }

    public Integer getChangenum() {
        return changenum;
    }

    public void setChangenum(Integer changenum) {
        this.changenum = changenum;
    }

    public String getBrokername() {
        return brokername;
    }

    public void setBrokername(String brokername) {
        this.brokername = brokername;
    }

    public Long getAllamount() {
        return allamount;
    }

    public void setAllamount(Long allamount) {
        this.allamount = allamount;
    }

    public Integer getContinuousday() {
        return continuousday;
    }

    public void setContinuousday(Integer continuousday) {
        this.continuousday = continuousday;
    }

    public String getChangerate() {
        return changerate;
    }

    public void setChangerate(String changerate) {
        this.changerate = changerate;
    }

    public Double getAllcost() {
        return allcost;
    }

    public void setAllcost(Double allcost) {
        this.allcost = allcost;
    }

    public Double getHoldrate() {
        return holdrate;
    }

    public void setHoldrate(Double holdrate) {
        this.holdrate = holdrate;
    }

    public String getIndustrycode() {
        return industrycode;
    }

    public void setIndustrycode(String industrycode) {
        this.industrycode = industrycode;
    }

    public String getIndustryname() {
        return industryname;
    }

    public void setIndustryname(String industryname) {
        this.industryname = industryname;
    }

    public Integer getMarket() {
        return market;
    }

    public void setMarket(Integer market) {
        this.market = market;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

}