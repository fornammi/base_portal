package com.bill99.rm.skeye.aba.model;

import java.io.Serializable;

public class MamCustomer implements Serializable {
	
	private static final long serialVersionUID = 2983024653294232339L;
	private String memberCode;
	private String identityCard;
	private String curAcctType;
	private String cstAcctType;
	private String idContent;
	public String getCurAcctType() {
		return curAcctType;
	}
	public void setCurAcctType(String curAcctType) {
		this.curAcctType = curAcctType;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getIdContent() {
		return idContent;
	}
	public void setIdContent(String idContent) {
		this.idContent = idContent;
	}
	public String getCstAcctType() {
		return cstAcctType;
	}
	public void setCstAcctType(String cstAcctType) {
		this.cstAcctType = cstAcctType;
	}
	public String toString(){
		return ("memberCode:"+this.memberCode+",identityCard:"+this.identityCard+",idContent:"+this.idContent+",curAcctType:"+this.curAcctType+",cstAcctType:"+this.cstAcctType);
		
	}
}