package com.yangyh.stockdemo.entity;

import java.io.Serializable;
    import java.util.Date;
    import java.lang.String;

/**
* @description:
* @author: Administrator
* @create: 2020-8-16 17:13:07
*/
public class CapitalEntity implements Serializable {

private static final long serialVersionUID = 1L;

    private String brokercode;
    private String brokername;
    private Date updatetime;

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
    public Date getUpdatetime() {
    return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
    this.updatetime = updatetime;
    }

}