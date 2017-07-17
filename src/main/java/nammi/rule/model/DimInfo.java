package nammi.rule.model;

import java.io.Serializable;

public class DimInfo implements Serializable{
	private static final long serialVersionUID = 6247702071700594643L;
	private Long dimId;
    private Long dimgroupId;
    private String name;
    private String parentheses;
    private Long dimItemId;
    private String calculateid;
    private String calculatevalue;
    private String operatorCompare;
    private String dimItemValue;
    private Long dimItemCompareId;
    private String operatorLogic;
    private String status;
    private String createUser;
    private java.util.Date createDate;
    private java.util.Date updateDate;
    private String orderField;



    public Long getDimId( ){
		    return dimId;
    }
    public void setDimId(Long dimId){
		    this.dimId=dimId;
    }

    public Long getDimgroupId( ){
		    return dimgroupId;
    }
    public void setDimgroupId(Long dimgroupId){
		    this.dimgroupId=dimgroupId;
    }

    public String getName( ){
		    return name;
    }
    public void setName(String name){
		    this.name=name;
    }

    public String getParentheses( ){
		    return parentheses;
    }
    public void setParentheses(String parentheses){
		    this.parentheses=parentheses;
    }

    public Long getDimItemId( ){
		    return dimItemId;
    }
    public void setDimItemId(Long dimItemId){
		    this.dimItemId=dimItemId;
    }

    public String getCalculateid( ){
		    return calculateid;
    }
    public void setCalculateid(String calculateid){
		    this.calculateid=calculateid;
    }

    public String getCalculatevalue( ){
		    return calculatevalue;
    }
    public void setCalculatevalue(String calculatevalue){
		    this.calculatevalue=calculatevalue;
    }

    public String getOperatorCompare( ){
		    return operatorCompare;
    }
    public void setOperatorCompare(String operatorCompare){
		    this.operatorCompare=operatorCompare;
    }

    public String getDimItemValue( ){
		    return dimItemValue;
    }
    public void setDimItemValue(String dimItemValue){
		    this.dimItemValue=dimItemValue;
    }

    public Long getDimItemCompareId( ){
		    return dimItemCompareId;
    }
    public void setDimItemCompareId(Long dimItemCompareId){
		    this.dimItemCompareId=dimItemCompareId;
    }

    public String getOperatorLogic( ){
		    return operatorLogic;
    }
    public void setOperatorLogic(String operatorLogic){
		    this.operatorLogic=operatorLogic;
    }

    public String getStatus( ){
		    return status;
    }
    public void setStatus(String status){
		    this.status=status;
    }

    public String getCreateUser( ){
		    return createUser;
    }
    public void setCreateUser(String createUser){
		    this.createUser=createUser;
    }

    public java.util.Date getCreateDate( ){
		    return createDate;
    }
    public void setCreateDate(java.util.Date createDate){
		    this.createDate=createDate;
    }

    public java.util.Date getUpdateDate( ){
		    return updateDate;
    }
    public void setUpdateDate(java.util.Date updateDate){
		    this.updateDate=updateDate;
    }

    public String getOrderField(){
		    return orderField;
    }
    public void setOrderField(String orderField){
		    this.orderField = orderField;
    }
}