package nammi.login.model;

public class LoginInfo{
    private Long id;
    private String codeNo;
    private String loginCode;
    private String password;
    private Long status;
    private String orderField;



    public Long getId( ){
		    return id;
    }
    public void setId(Long id){
		    this.id=id;
    }

    public String getCodeNo( ){
		    return codeNo;
    }
    public void setCodeNo(String codeNo){
		    this.codeNo=codeNo;
    }

    public String getLoginCode( ){
		    return loginCode;
    }
    public void setLoginCode(String loginCode){
		    this.loginCode=loginCode;
    }

    public String getPassword( ){
		    return password;
    }
    public void setPassword(String password){
		    this.password=password;
    }

    public Long getStatus( ){
		    return status;
    }
    public void setStatus(Long status){
		    this.status=status;
    }

    public String getOrderField(){
		    return orderField;
    }
    public void setOrderField(String orderField){
		    this.orderField = orderField;
    }
}