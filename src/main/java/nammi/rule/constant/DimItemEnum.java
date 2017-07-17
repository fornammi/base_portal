package nammi.rule.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DIM项枚举类
 * @author daniel.fang
 *
 */
public enum DimItemEnum {
	
	DIM_1(1L, "交易金额", "txnAmount", null, DimItemTypeConstants.DIM_ITEM_TYPE_NUMBER),
	DIM_2(2L, "持卡人姓名", "cardholderName", null, DimItemTypeConstants.DIM_ITEM_TYPE_STRING),
	DIM_3(3L, "卡号", "bankCardNo", null, DimItemTypeConstants.DIM_ITEM_TYPE_STRING),
	DIM_4(4L, "交易时间", "txnTime", null, DimItemTypeConstants.DIM_ITEM_TYPE_DATE);

	public static final List<DimItemEnum> dimItemList;
	public static final Map<Long, DimItemEnum> dimItemMap;
	static{
		dimItemList = new ArrayList<DimItemEnum>();
		dimItemMap = new HashMap<Long, DimItemEnum>();
		DimItemEnum[] vals = DimItemEnum.values();
		for(DimItemEnum data : vals){
			dimItemList.add(data);
			dimItemMap.put(data.getDimItemId(), data);
		}
	}
	
	private Long dimItemId;
	private String dimItemDesc;
	private String mappingBoPro;
	private String mappingSetName;
	private int dimItemType;
	
	
	private DimItemEnum(Long dimItemId, String dimItemDesc, String mappingBoPro, String mappingSetName,
			int dimItemType) {
		this.dimItemId = dimItemId;
		this.dimItemDesc = dimItemDesc;
		this.mappingBoPro = mappingBoPro;
		this.mappingSetName = mappingSetName;
		this.dimItemType = dimItemType;
	}
	
	
	public Long getDimItemId() {
		return dimItemId;
	}
	public void setDimItemId(Long dimItemId) {
		this.dimItemId = dimItemId;
	}
	public String getDimItemDesc() {
		return dimItemDesc;
	}
	public void setDimItemDesc(String dimItemDesc) {
		this.dimItemDesc = dimItemDesc;
	}
	public String getMappingBoPro() {
		return mappingBoPro;
	}
	public void setMappingBoPro(String mappingBoPro) {
		this.mappingBoPro = mappingBoPro;
	}
	public String getMappingSetName() {
		return mappingSetName;
	}
	public void setMappingSetName(String mappingSetName) {
		this.mappingSetName = mappingSetName;
	}
	public int getDimItemType() {
		return dimItemType;
	}
	public void setDimItemType(int dimItemType) {
		this.dimItemType = dimItemType;
	}
	
}
