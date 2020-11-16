//package com.yangyh.stockdemo.entity;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.io.Serializable;
//
///**
//* @description:
//* @author: Administrator
//* @create: 2020-8-11 23:49:24
//*/
//
//@Document(indexName = "capitalHold", type = "_doc", useServerConfiguration = true, createIndex = false)
//public class CapitalHoldIndex implements Serializable {
//
//private static final long serialVersionUID = 1L;
//
//    @Id
//    @Field(type= FieldType.Auto)
//    private String id;
//
//    @Field(type = FieldType.Text)
//    private String profitlossrate;
//
//    @Field(type = FieldType.Integer)
//    private Integer holdtrendimgurl;
//
//    @Field(type = FieldType.Text)
//    private String tradeday;
//
//    @Field(type = FieldType.Text)
//    private String brokercode;
//
//    @Field(type = FieldType.Text)
//    private String stockcode;
//
//    @Field(type = FieldType.Long)
//    private Long marketvalue;
//
//    @Field(type = FieldType.Double)
//    private Double profitloss;
//
//    @Field(type = FieldType.Double)
//    private Double percost;
//
//    @Field(type = FieldType.Integer)
//    private Integer isnew;
//
//    @Field(type = FieldType.Integer)
//    private Integer holdnum;
//
//    @Field(type = FieldType.Integer)
//    private Integer changenum;
//
//    @Field(type = FieldType.Text)
//    private String brokername;
//
//    @Field(type = FieldType.Long)
//    private Long allamount;
//
//    @Field(type = FieldType.Integer)
//    private Integer continuousday;
//
//    @Field(type = FieldType.Text)
//    private String changerate;
//
//    @Field(type = FieldType.Double)
//    private Double allcost;
//
//    @Field(type = FieldType.Double)
//    private Double holdrate;
//
//    @Field(type = FieldType.Text)
//    private String industrycode;
//
//    @Field(type = FieldType.Text)
//    private String industryname;
//
//    @Field(type = FieldType.Integer)
//    private Integer market;
//
//    @Field(type = FieldType.Text)
//    private String stockname;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getProfitlossrate() {
//    return profitlossrate;
//    }
//
//    public void setProfitlossrate(String profitlossrate) {
//    this.profitlossrate = profitlossrate;
//    }
//    public Integer getHoldtrendimgurl() {
//    return holdtrendimgurl;
//    }
//
//    public void setHoldtrendimgurl(Integer holdtrendimgurl) {
//    this.holdtrendimgurl = holdtrendimgurl;
//    }
//    public String getTradeday() {
//    return tradeday;
//    }
//
//    public void setTradeday(String tradeday) {
//    this.tradeday = tradeday;
//    }
//    public String getBrokercode() {
//    return brokercode;
//    }
//
//    public void setBrokercode(String brokercode) {
//    this.brokercode = brokercode;
//    }
//    public String getStockcode() {
//    return stockcode;
//    }
//
//    public void setStockcode(String stockcode) {
//    this.stockcode = stockcode;
//    }
//    public Long getMarketvalue() {
//    return marketvalue;
//    }
//
//    public void setMarketvalue(Long marketvalue) {
//    this.marketvalue = marketvalue;
//    }
//    public Double getProfitloss() {
//    return profitloss;
//    }
//
//    public void setProfitloss(Double profitloss) {
//    this.profitloss = profitloss;
//    }
//    public Double getPercost() {
//    return percost;
//    }
//
//    public void setPercost(Double percost) {
//    this.percost = percost;
//    }
//    public Integer getIsnew() {
//    return isnew;
//    }
//
//    public void setIsnew(Integer isnew) {
//    this.isnew = isnew;
//    }
//    public Integer getHoldnum() {
//    return holdnum;
//    }
//
//    public void setHoldnum(Integer holdnum) {
//    this.holdnum = holdnum;
//    }
//    public Integer getChangenum() {
//    return changenum;
//    }
//
//    public void setChangenum(Integer changenum) {
//    this.changenum = changenum;
//    }
//    public String getBrokername() {
//    return brokername;
//    }
//
//    public void setBrokername(String brokername) {
//    this.brokername = brokername;
//    }
//    public Long getAllamount() {
//    return allamount;
//    }
//
//    public void setAllamount(Long allamount) {
//    this.allamount = allamount;
//    }
//    public Integer getContinuousday() {
//    return continuousday;
//    }
//
//    public void setContinuousday(Integer continuousday) {
//    this.continuousday = continuousday;
//    }
//    public String getChangerate() {
//    return changerate;
//    }
//
//    public void setChangerate(String changerate) {
//    this.changerate = changerate;
//    }
//    public Double getAllcost() {
//    return allcost;
//    }
//
//    public void setAllcost(Double allcost) {
//    this.allcost = allcost;
//    }
//    public Double getHoldrate() {
//    return holdrate;
//    }
//
//    public void setHoldrate(Double holdrate) {
//    this.holdrate = holdrate;
//    }
//    public String getIndustrycode() {
//    return industrycode;
//    }
//
//    public void setIndustrycode(String industrycode) {
//    this.industrycode = industrycode;
//    }
//    public String getIndustryname() {
//    return industryname;
//    }
//
//    public void setIndustryname(String industryname) {
//    this.industryname = industryname;
//    }
//    public Integer getMarket() {
//    return market;
//    }
//
//    public void setMarket(Integer market) {
//    this.market = market;
//    }
//    public String getStockname() {
//    return stockname;
//    }
//
//    public void setStockname(String stockname) {
//    this.stockname = stockname;
//    }
//
//}