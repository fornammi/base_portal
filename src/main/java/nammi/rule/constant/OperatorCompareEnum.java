package nammi.rule.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作符枚举
 * @author daniel.fang
 *
 */
public enum OperatorCompareEnum {

	/**
	 * 大于
	 * */
	GREATER("1", ">", "大于"),
	/**
	 * 小于
	 * */
	LESS("2", "<", "小于"),
	/**
	 * 等于
	 * */
	EQUAL("3", "==", "等于"),
	/**
	 * 不等于
	 * */
	NOT_EQUAL("4", "!=", "不等于"),
	/**
	 * 大于等于
	 * */
	GREATER_THAN_OR_EQUAL("5", ">=", "大于等于"),
	/**
	 * 小于等于
	 * */
	LESS_THAN_OR_EQUAL("6", "<=", "小于等于"),
	/**
	 * 不存在
	 * */
	NOT_EXIST("7", "", "不存在"),
	/**
	 * 包含
	 * */
	INCLUDE("8", "contains", "包含"),
	/**
	 * 不包含
	 * */
	NOT_INCLUDE("9", "not contains", "不包含"),
	/**
	 * 属于
	 * */
	BELONG("10", "memberOf", "属于"),
	/**
	 * 不属于
	 * */
	NOT_BELONG("11", "not memberOf", "不属于"),
	/**
	 * 不属于
	 * */
	MATCHES("12", "matches", "匹配"),
	/**
	 * 不属于
	 * */
	NOT_MATCHES("13", "not matches", "不匹配"),
	/**
	 * 存在
	 * */
	EXIST("14", "", "存在");

	public String getId() {
		return id;
	}

	public String getOperator() {
		return operator;
	}

	public String getDesc() {
		return desc;
	}

	public final static Map<String, OperatorCompareEnum> operatorCompareMap;
	static {
		operatorCompareMap = new HashMap<String, OperatorCompareEnum>();
		OperatorCompareEnum[] vals = OperatorCompareEnum.values();
		for(OperatorCompareEnum data : vals){
			operatorCompareMap.put(data.getId(), data);
		}
	}

	private OperatorCompareEnum(String id, String operator, String desc) {
		this.id = id;
		this.operator = operator;
		this.desc = desc;
	}

	private String id;
	private String operator;
	private String desc;
}
