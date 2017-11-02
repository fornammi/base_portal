package redis;

import java.io.Serializable;
import java.util.Date;

/**
 * 风险等级开关实体类
 * 
 * @author leo.feng
 */
public class TRmSwitchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3084249459822447055L;

	private Long id;

	private Integer switchStatus;

	private Integer rmcaSwitchStatus;

	private Integer masStatus;

	private String description;

	private String createUser;

	private Date createDate;

	private Integer rmaFrequency;

	private Integer maxScore;

	private boolean cybsSwtich; // CYBS_DM审核开关 0关1开

	private boolean integrateAuditSwitch; // 综合审核开关 0关1开

	private Integer mrcsJobSwitch; //MRCS-定时任务开关	0关1开

	private Integer mrcsAuditSwitch; //MRCS-商户审核开关	0关1开

	private Integer rmisSwitch; //rmis-开关	0关1开

	private Integer rmisAuditSwitch; //rmis审核开关 0关1开

	private Integer rmisAnalysisSwitch;//rmis分析开关 0关1开

	private Integer rmisLoadSwitch;//rmis装载开关 0关1开
	
	private Integer rmisECTConcurrentExecute;// rmis交易抽取并发执行开关
	
	private Integer rmaAuditSwitch;//rma审核开关 0关1开
	
	private Integer rmCacheSwitch; // rm缓存控制1：memcached 2：redis 3：同时写
	
	private Integer callTmsSwitch;	//实时交易数据传输给宏基tms开关：0关1开

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSwitchStatus() {
		return switchStatus;
	}

	public void setSwitchStatus(Integer switchStatus) {
		this.switchStatus = switchStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		if (description != null) {
			this.description = description.trim();
		}
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
		if (createUser != null) {
			this.createUser = createUser.trim();
		}
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public Integer getRmaFrequency() {
		return rmaFrequency;
	}

	public void setRmaFrequency(Integer rmaFrequency) {
		this.rmaFrequency = rmaFrequency;
	}

	public void setMasStatus(Integer masStatus) {
		this.masStatus = masStatus;
	}

	public Integer getMasStatus() {
		return masStatus;
	}

	public void setRmcaSwitchStatus(Integer rmcaSwitchStatus) {
		this.rmcaSwitchStatus = rmcaSwitchStatus;
	}

	public Integer getRmcaSwitchStatus() {
		return rmcaSwitchStatus;
	}

	public boolean getCybsSwtich() {
		return cybsSwtich;
	}

	public void setCybsSwtich(boolean cybsSwtich) {
		this.cybsSwtich = cybsSwtich;
	}

	public boolean getIntegrateAuditSwitch() {
		return integrateAuditSwitch;
	}

	public void setIntegrateAuditSwitch(boolean integrateAuditSwitch) {
		this.integrateAuditSwitch = integrateAuditSwitch;
	}

	public Integer getMrcsJobSwitch() {
		return mrcsJobSwitch;
	}

	public void setMrcsJobSwitch(Integer mrcsJobSwitch) {
		this.mrcsJobSwitch = mrcsJobSwitch;
	}

	public Integer getMrcsAuditSwitch() {
		return mrcsAuditSwitch;
	}

	public void setMrcsAuditSwitch(Integer mrcsAuditSwitch) {
		this.mrcsAuditSwitch = mrcsAuditSwitch;
	}

	public void setRmisSwitch(Integer rmisSwitch) {
		this.rmisSwitch = rmisSwitch;
	}

	public Integer getRmisSwitch() {
		return rmisSwitch;
	}

	public void setRmisAuditSwitch(Integer rmisAuditSwitch) {
		this.rmisAuditSwitch = rmisAuditSwitch;
	}

	public Integer getRmisAuditSwitch() {
		return rmisAuditSwitch;
	}

	public void setRmisAnalysisSwitch(Integer rmisAnalysisSwitch) {
		this.rmisAnalysisSwitch = rmisAnalysisSwitch;
	}

	public Integer getRmisAnalysisSwitch() {
		return rmisAnalysisSwitch;
	}

	public void setRmisLoadSwitch(Integer rmisLoadSwitch) {
		this.rmisLoadSwitch = rmisLoadSwitch;
	}

	public Integer getRmisLoadSwitch() {
		return rmisLoadSwitch;
	}

	public void setRmaAuditSwitch(Integer rmaAuditSwitch) {
		this.rmaAuditSwitch = rmaAuditSwitch;
	}

	public Integer getRmaAuditSwitch() {
		return rmaAuditSwitch;
	}

	public Integer getRmCacheSwitch() {
		return rmCacheSwitch;
	}

	public void setRmCacheSwitch(Integer rmCacheSwitch) {
		this.rmCacheSwitch = rmCacheSwitch;
	}
	
	public Integer getRmisECTConcurrentExecute() {
		return rmisECTConcurrentExecute;
	}
	
	public void setRmisECTConcurrentExecute(Integer rmisECTConcurrentExecute) {
		this.rmisECTConcurrentExecute = rmisECTConcurrentExecute;
	}

	public Integer getCallTmsSwitch() {
		return callTmsSwitch;
	}

	public void setCallTmsSwitch(Integer callTmsSwitch) {
		this.callTmsSwitch = callTmsSwitch;
	}
	
}
