package rule.engine.skeye;

import java.io.Serializable;

public class RtmsTradeApply implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private Long tradeId;
    private String appId;
    private Long functionCode;
    private String merchantCode;
    private String outTradeNo;
    private Long payAmount;
    private Long status;
    private String errorCode;
    private String errorInfo;
    private String memberCode;
    private String authCode;
    private Long channelType;
    private Long payMode;
    private Long secureType;
    private Long fundMode;
    private Long refundStatus;
    private Long refundAmount;
    private Long couponAmount;
    private String currencyCode;
    private java.util.Date valueDate;
    private java.util.Date txnTimeStart;
    private java.util.Date txnTimeExpire;
    private java.util.Date txnTimeEnd;
    private java.util.Date txnTimeVoid;
    private String txnSendIp;
    private String bankAcctId;
    private String bankAcctType;
    private String bankAcctName;
    private String refNum;
    private String billOrderId;
    private Long batchId;
    private String productTag;
    private String productDesc;
    private String subMerchantId;
    private String subMerchantName;
    private String subTerminalId;
    private String deviceInfo;
    private String stlMerchantCode;
    private String memo;
    private java.util.Date crtTime;
    private java.util.Date updTime;
    private String refIdTxn;
    private String refIdCtrl;
    private String memberBankId;
    private String mainMerchantId;
    private Long shareAmount;
    private Long equityFlag;
    private Long netAmount;
    private Long orderType;
    private String couponCode;
    private Long hitStatus;
    private Long hitTime;
    private String orderField;



    public Long getId( ){
		    return id;
    }
    public void setId(Long id){
		    this.id=id;
    }

    public Long getTradeId( ){
		    return tradeId;
    }
    public void setTradeId(Long tradeId){
		    this.tradeId=tradeId;
    }

    public String getAppId( ){
		    return appId;
    }
    public void setAppId(String appId){
		    this.appId=appId;
    }

    public Long getFunctionCode( ){
		    return functionCode;
    }
    public void setFunctionCode(Long functionCode){
		    this.functionCode=functionCode;
    }

    public String getMerchantCode( ){
		    return merchantCode;
    }
    public void setMerchantCode(String merchantCode){
		    this.merchantCode=merchantCode;
    }

    public String getOutTradeNo( ){
		    return outTradeNo;
    }
    public void setOutTradeNo(String outTradeNo){
		    this.outTradeNo=outTradeNo;
    }

    public Long getPayAmount( ){
		    return payAmount;
    }
    public void setPayAmount(Long payAmount){
		    this.payAmount=payAmount;
    }

    public Long getStatus( ){
		    return status;
    }
    public void setStatus(Long status){
		    this.status=status;
    }

    public String getErrorCode( ){
		    return errorCode;
    }
    public void setErrorCode(String errorCode){
		    this.errorCode=errorCode;
    }

    public String getErrorInfo( ){
		    return errorInfo;
    }
    public void setErrorInfo(String errorInfo){
		    this.errorInfo=errorInfo;
    }

    public String getMemberCode( ){
		    return memberCode;
    }
    public void setMemberCode(String memberCode){
		    this.memberCode=memberCode;
    }

    public String getAuthCode( ){
		    return authCode;
    }
    public void setAuthCode(String authCode){
		    this.authCode=authCode;
    }

    public Long getChannelType( ){
		    return channelType;
    }
    public void setChannelType(Long channelType){
		    this.channelType=channelType;
    }

    public Long getPayMode( ){
		    return payMode;
    }
    public void setPayMode(Long payMode){
		    this.payMode=payMode;
    }

    public Long getSecureType( ){
		    return secureType;
    }
    public void setSecureType(Long secureType){
		    this.secureType=secureType;
    }

    public Long getFundMode( ){
		    return fundMode;
    }
    public void setFundMode(Long fundMode){
		    this.fundMode=fundMode;
    }

    public Long getRefundStatus( ){
		    return refundStatus;
    }
    public void setRefundStatus(Long refundStatus){
		    this.refundStatus=refundStatus;
    }

    public Long getRefundAmount( ){
		    return refundAmount;
    }
    public void setRefundAmount(Long refundAmount){
		    this.refundAmount=refundAmount;
    }

    public Long getCouponAmount( ){
		    return couponAmount;
    }
    public void setCouponAmount(Long couponAmount){
		    this.couponAmount=couponAmount;
    }

    public String getCurrencyCode( ){
		    return currencyCode;
    }
    public void setCurrencyCode(String currencyCode){
		    this.currencyCode=currencyCode;
    }

    public java.util.Date getValueDate( ){
		    return valueDate;
    }
    public void setValueDate(java.util.Date valueDate){
		    this.valueDate=valueDate;
    }

    public java.util.Date getTxnTimeStart( ){
		    return txnTimeStart;
    }
    public void setTxnTimeStart(java.util.Date txnTimeStart){
		    this.txnTimeStart=txnTimeStart;
    }

    public java.util.Date getTxnTimeExpire( ){
		    return txnTimeExpire;
    }
    public void setTxnTimeExpire(java.util.Date txnTimeExpire){
		    this.txnTimeExpire=txnTimeExpire;
    }

    public java.util.Date getTxnTimeEnd( ){
		    return txnTimeEnd;
    }
    public void setTxnTimeEnd(java.util.Date txnTimeEnd){
		    this.txnTimeEnd=txnTimeEnd;
    }

    public java.util.Date getTxnTimeVoid( ){
		    return txnTimeVoid;
    }
    public void setTxnTimeVoid(java.util.Date txnTimeVoid){
		    this.txnTimeVoid=txnTimeVoid;
    }

    public String getTxnSendIp( ){
		    return txnSendIp;
    }
    public void setTxnSendIp(String txnSendIp){
		    this.txnSendIp=txnSendIp;
    }

    public String getBankAcctId( ){
		    return bankAcctId;
    }
    public void setBankAcctId(String bankAcctId){
		    this.bankAcctId=bankAcctId;
    }

    public String getBankAcctType( ){
		    return bankAcctType;
    }
    public void setBankAcctType(String bankAcctType){
		    this.bankAcctType=bankAcctType;
    }

    public String getBankAcctName( ){
		    return bankAcctName;
    }
    public void setBankAcctName(String bankAcctName){
		    this.bankAcctName=bankAcctName;
    }

    public String getRefNum( ){
		    return refNum;
    }
    public void setRefNum(String refNum){
		    this.refNum=refNum;
    }

    public String getBillOrderId( ){
		    return billOrderId;
    }
    public void setBillOrderId(String billOrderId){
		    this.billOrderId=billOrderId;
    }

    public Long getBatchId( ){
		    return batchId;
    }
    public void setBatchId(Long batchId){
		    this.batchId=batchId;
    }

    public String getProductTag( ){
		    return productTag;
    }
    public void setProductTag(String productTag){
		    this.productTag=productTag;
    }

    public String getProductDesc( ){
		    return productDesc;
    }
    public void setProductDesc(String productDesc){
		    this.productDesc=productDesc;
    }

    public String getSubMerchantId( ){
		    return subMerchantId;
    }
    public void setSubMerchantId(String subMerchantId){
		    this.subMerchantId=subMerchantId;
    }

    public String getSubMerchantName( ){
		    return subMerchantName;
    }
    public void setSubMerchantName(String subMerchantName){
		    this.subMerchantName=subMerchantName;
    }

    public String getSubTerminalId( ){
		    return subTerminalId;
    }
    public void setSubTerminalId(String subTerminalId){
		    this.subTerminalId=subTerminalId;
    }

    public String getDeviceInfo( ){
		    return deviceInfo;
    }
    public void setDeviceInfo(String deviceInfo){
		    this.deviceInfo=deviceInfo;
    }

    public String getStlMerchantCode( ){
		    return stlMerchantCode;
    }
    public void setStlMerchantCode(String stlMerchantCode){
		    this.stlMerchantCode=stlMerchantCode;
    }

    public String getMemo( ){
		    return memo;
    }
    public void setMemo(String memo){
		    this.memo=memo;
    }

    public java.util.Date getCrtTime( ){
		    return crtTime;
    }
    public void setCrtTime(java.util.Date crtTime){
		    this.crtTime=crtTime;
    }

    public java.util.Date getUpdTime( ){
		    return updTime;
    }
    public void setUpdTime(java.util.Date updTime){
		    this.updTime=updTime;
    }

    public String getRefIdTxn( ){
		    return refIdTxn;
    }
    public void setRefIdTxn(String refIdTxn){
		    this.refIdTxn=refIdTxn;
    }

    public String getRefIdCtrl( ){
		    return refIdCtrl;
    }
    public void setRefIdCtrl(String refIdCtrl){
		    this.refIdCtrl=refIdCtrl;
    }

    public String getMemberBankId( ){
		    return memberBankId;
    }
    public void setMemberBankId(String memberBankId){
		    this.memberBankId=memberBankId;
    }

    public String getMainMerchantId( ){
		    return mainMerchantId;
    }
    public void setMainMerchantId(String mainMerchantId){
		    this.mainMerchantId=mainMerchantId;
    }

    public Long getShareAmount( ){
		    return shareAmount;
    }
    public void setShareAmount(Long shareAmount){
		    this.shareAmount=shareAmount;
    }

    public Long getEquityFlag( ){
		    return equityFlag;
    }
    public void setEquityFlag(Long equityFlag){
		    this.equityFlag=equityFlag;
    }

    public Long getNetAmount( ){
		    return netAmount;
    }
    public void setNetAmount(Long netAmount){
		    this.netAmount=netAmount;
    }

    public Long getOrderType( ){
		    return orderType;
    }
    public void setOrderType(Long orderType){
		    this.orderType=orderType;
    }

    public String getCouponCode( ){
		    return couponCode;
    }
    public void setCouponCode(String couponCode){
		    this.couponCode=couponCode;
    }

    public Long getHitStatus( ){
		    return hitStatus;
    }
    public void setHitStatus(Long hitStatus){
		    this.hitStatus=hitStatus;
    }

    public Long getHitTime( ){
		    return hitTime;
    }
    public void setHitTime(Long hitTime){
		    this.hitTime=hitTime;
    }

    public String getOrderField(){
		    return orderField;
    }
    public void setOrderField(String orderField){
		    this.orderField = orderField;
    }
}