/**
 * 
 */
package nammi.rule.engine.drools.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bill99.rmca.dim.entity.Dim;

/**
 * @author feibu.wang
 *
 * @date 2011-4-15
 */
public class DimGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long ruleId;	//RULE_ID
	
	private String name;	//DIM组名称
	private BigDecimal weight;	//DIM组权重
	private Long score;	//DIM组得分
	private String drl;	//DIM组_DRL
	private Boolean status;	//状态 1有效0删除
	
	private String createUser;	//创建人
	private Date createDate;	//创建日期
	private Date updateTime;	//最后更新时间
	
	private List<Dim> dimList;	//关联dim集
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getDrl() {
		return drl;
	}
	public void setDrl(String drl) {
		this.drl = drl;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public List<Dim> getDimList() {
		return dimList;
	}
	public void setDimList(List<Dim> dimList) {
		this.dimList = dimList;
	}
}
