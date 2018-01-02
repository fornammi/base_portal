package com.test.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class MerchantLimit implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
    private String upMerchantId;
    private String merchantTerminalId;
    private String merchantName;
    private BigDecimal minLimit;
    private BigDecimal maxLimit;
    private java.util.Date expiryDate;
    private String payMode;
    private String limitRemark;
    private String limitStatus;
    private String opType;
    private String createrCode;
    private String createrName;
    private java.util.Date crtTime;
    private String updaterCode;
    private String updaterName;
    private java.util.Date updTime;
    private String orderField;
    private String payModeName;

    public MerchantLimit() {
		super();
	}
    
    
	public Long getId( ){
		    return id;
    }
    public void setId(Long id){
		    this.id=id;
    }

    public String getUpMerchantId( ){
		    return upMerchantId;
    }
    public void setUpMerchantId(String upMerchantId){
		    this.upMerchantId=upMerchantId;
    }

    public String getMerchantTerminalId( ){
		    return merchantTerminalId;
    }
    public void setMerchantTerminalId(String merchantTerminalId){
		    this.merchantTerminalId=merchantTerminalId;
    }

    public String getMerchantName( ){
		    return merchantName;
    }
    public void setMerchantName(String merchantName){
		    this.merchantName=merchantName;
    }

    public BigDecimal getMinLimit( ){
		    return minLimit;
    }
    public void setMinLimit(BigDecimal minLimit){
		    this.minLimit=minLimit;
    }

    public BigDecimal getMaxLimit( ){
		    return maxLimit;
    }
    public void setMaxLimit(BigDecimal maxLimit){
		    this.maxLimit=maxLimit;
    }

    public java.util.Date getExpiryDate( ){
		    return expiryDate;
    }
    public void setExpiryDate(java.util.Date expiryDate){
		    this.expiryDate=expiryDate;
    }

    public String getPayMode( ){
		    return payMode;
    }
    public void setPayMode(String payMode){
		    this.payMode=payMode;
    }

    public String getLimitRemark( ){
		    return limitRemark;
    }
    public void setLimitRemark(String limitRemark){
		    this.limitRemark=limitRemark;
    }

    public String getLimitStatus( ){
		    return limitStatus;
    }
    public void setLimitStatus(String limitStatus){
		    this.limitStatus=limitStatus;
    }

    public String getOpType( ){
		    return opType;
    }
    public void setOpType(String opType){
		    this.opType=opType;
    }

    public String getCreaterCode( ){
		    return createrCode;
    }
    public void setCreaterCode(String createrCode){
		    this.createrCode=createrCode;
    }

    public String getCreaterName( ){
		    return createrName;
    }
    public void setCreaterName(String createrName){
		    this.createrName=createrName;
    }

    public java.util.Date getCrtTime( ){
		    return crtTime;
    }
    public void setCrtTime(java.util.Date crtTime){
		    this.crtTime=crtTime;
    }

    public String getUpdaterCode( ){
		    return updaterCode;
    }
    public void setUpdaterCode(String updaterCode){
		    this.updaterCode=updaterCode;
    }

    public String getUpdaterName( ){
		    return updaterName;
    }
    public void setUpdaterName(String updaterName){
		    this.updaterName=updaterName;
    }

    public java.util.Date getUpdTime( ){
		    return updTime;
    }
    public void setUpdTime(java.util.Date updTime){
		    this.updTime=updTime;
    }

    public String getOrderField(){
		    return orderField;
    }
    public void setOrderField(String orderField){
		    this.orderField = orderField;
    }
    
    
    @Override
	public String toString() {
		return "MerchantLimit [id=" + id + ", upMerchantId=" + upMerchantId + ", merchantTerminalId="
				+ merchantTerminalId + ", merchantName=" + merchantName + ", minLimit=" + minLimit + ", maxLimit="
				+ maxLimit + ", expiryDate=" + expiryDate + ", payMode=" + payMode + ", limitRemark=" + limitRemark
				+ ", limitStatus=" + limitStatus + ", opType=" + opType + ", createrCode=" + createrCode
				+ ", createrName=" + createrName + ", crtTime=" + crtTime + ", updaterCode=" + updaterCode
				+ ", updaterName=" + updaterName + ", updTime=" + updTime + ", orderField=" + orderField
				+ ", payModeName=" + payModeName + "]";
	}
    
    
	public String getPayModeName() {
		return payModeName;
	}
	public void setPayModeName(String payModeName) {
		this.payModeName = payModeName;
	}
	public String getLimitStatusName(){
    	if(StringUtils.isBlank(limitStatus)){
    		return "";
    	}
    	if("1".equals(limitStatus)){
    		return "有效";
    	}else if("0".equals(limitStatus)){
    		return "无效";
    	}else{
    		return "";
    	}
    }
	
	public String getShortLimitRemark(){
		if(StringUtils.isBlank(limitRemark)){
			return "";
		}
		int len = limitRemark.length();
		if(len>5){
			StringBuffer sb = new StringBuffer();
			sb.append(limitRemark.substring(0, 5)).append(" ......");
			return sb.toString();
		}else{
			return limitRemark;
		}
	}
	
}