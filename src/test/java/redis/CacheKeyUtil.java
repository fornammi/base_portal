package redis;

public class CacheKeyUtil {
	
	// 用于动态黑白名单的交易
	public static final String WBLIST_TXN_KEY = "wblist.rule.txn.";

	// 黑名单实例
	public final static String RM_CPS_BLACKLIST_KEY = "rm.cps.0001.";

	// 白名单知识库
	public final static String RM_CPS_WHITELIST_KEY = "rm.cps.0002.";

	// 银行前规则相关
	public final static String RM_CPS_ABOVEBANK_RULE_INSTANCE_KEY = "rm.cps.0003.";

	// 银行后规则相关
	public final static String RM_CPS_BEHINDBANK_RULE_INSTANCE_KEY = "rm.cps.0004.";

	// 银行前规则知识库
	public final static String RM_CPS_ABOVEBANK_RULE_KBASE_KEY = "rm.cps.0005.";

	// 银行后规则知识库
	public final static String RM_CPS_BEHINDBANK_RULE_KBASE_KEY = "rm.cps.0006.";

	// 银行前rule对应分值
	public final static String RM_CPS_ABOVEBANK_RULE_SCORE_KEY = "rm.cps.0007.";

	// 银行后rule对应分值
	public final static String RM_CPS_BEHINDBANK_RULE_SCORE_KEY = "rm.cps.0008.";

	//银行前行业rule所对应的MO 集合
	public final static String RM_CPS_AB_IND_RULE_MO_KEY = "rm.cps.0009.";

	//银行前行业rule所对应的MO 集合
	public final static String RM_CPS_BB_IND_RULE_MO_KEY = "rm.cps.0010.";

	//银行前通用rule所对应的MO 集合
	public final static String RM_CPS_BB_COMM_RULE_MO_KEY = "rm.cps.0011.";

	//mo对象
	public final static String RM_CPS_MOASSOCIATIONDTO_KEY = "rm.cps.0012.";

	// 行业关系
	public final static String RM_INDUSTRY_INSTANCE_KEY = "rm.cps.0013.";

	//DIM必须数据
	public final static String RM_NECDIMDATA_INSTANCE_KEY = "rm.cps.0014.";

	//银行后DIM必须数据
	public final static String RM_NECDIMDATA_BB_INSTANCE_KEY = "rm.cps.0015.";

	public final static String RM_CPS_RULE_KBASE_KEY = "rm.cps.0016.";
	//银行前审核所需MOID集合
	public final static String RM_AB_AUDIT_MOID_SET_KEY = "rm.cps.0017.";
	//银行后审核所需MOID集合
	public final static String RM_BB_AUDIT_MOID_SET_KEY = "rm.cps.0018.";
	
	// MO的生效范围 by leo.cao 2015-9-7
	public final static String MO_RANGE_CC_QRY_KEY = "cc.qry"; // CallCenter查询交易
	public final static String MO_RANGE_CC_NOT_QRY_KEY = "cc.sale";// CallCenter消费交易
	public final static String MO_RANGE_CNP_NOT_QRY_KEY = "cnp.noqry"; // 普通CNP除去查询
	public final static String MO_RANGE_ALL_KEY = "all.all";// 全部交易类型

	public final static String RM_MO_RULE_CONST_KEY = "rm.cps.0019.";

	public final static String RM_AUDIT_RANGE_KSESSION = "rm.cps.0020.";

	public final static String RM_AGENT_INSTANCE_KEY = "rm.cps.0021.";

	public final static String RM_AUDITR_RANGE_MAP_KEY = "rm.cps.0022.";

	public final static String RMCA_CPS_DEVICEID_RATEDATA_KEY = "rm.cps.0023.";
	public final static String RMCA_CPS_DHRBILLADDRESS_RATEDATA_KEY = "rm.cps.0024.";
	public final static String RMCA_CPS_EXTTRACENOSERVICE_RATEDATA_KEY = "rm.cps.0025.";
	public final static String RMCA_CPS_PAN_RATEDATA_KEY = "rm.cps.0026.";
	public final static String RMCA_CPS_PAYIP_RATEDATA_KEY = "rm.cps.0027.";
	public final static String RMCA_CPS_RCVADDRESS_RATEDATA_KEY = "rm.cps.0028.";
	
	//乘机人手机号
	public final static String RMCA_CPS_TBPPHONE_RATEDATA_KEY = "rm.cps.0029.";
	//持卡人手机号
	public final static String RMCA_CPS_CARDHOLDERPHONE_RATEDATA_KEY = "rm.cps.0030.";

	// 刷新审核商户范围 by leo.cao 2016.10.17
	public static final String RMCA_REFRESH_AUDIT_RANGE_KEY = "rmca.refresh.auditRange";

}
