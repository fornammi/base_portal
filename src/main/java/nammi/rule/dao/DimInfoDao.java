package nammi.rule.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bill99.inf.ibatis.PageInfo;

import nammi.rule.model.DimInfo;

//@Repository
public class DimInfoDao extends com.bill99.inf.ibatis.BaseDao{
	public DimInfo createDimInfo(DimInfo model){
		//model.setId(super.getSequence("seqName"));//如果主键是sequence生成
		dao.insert("dimInfo.insertDimInfo",model);
		return model;
	}

	public void deleteDimInfo(Object id){
		dao.delete("dimInfo.deleteDimInfo",id);
	}

	public void updateDimInfo(DimInfo model){
		dao.update("dimInfo.updateDimInfo",model);
	}

	public List<DimInfo> queryDimInfoByModel(DimInfo model){
		return (List<DimInfo>)dao.queryForList("dimInfo.queryModelDimInfo",model);
	}

	public List<DimInfo> queryDimInfoByModelPage(DimInfo model,PageInfo page){
		return (List<DimInfo>)dao.queryForList("dimInfo.queryModelDimInfo",model,page);
	}

	public List<DimInfo> queryDimInfoByMap(Map  map){
		return (List<DimInfo>)dao.queryForList("dimInfo.queryMapDimInfo",map);
	}

	public List<DimInfo> queryDimInfoByMapPage(Map  map,PageInfo page){
		return (List<DimInfo>)dao.queryForList("dimInfo.queryMapDimInfo",map,page);
	}

	public DimInfo findDimInfoByModel(DimInfo model){
		return (DimInfo)dao.queryForObject("dimInfo.queryModelDimInfo",model);
	}
	public DimInfo findDimInfoByMap(Map  map){
		return (DimInfo)dao.queryForObject("dimInfo.queryMapDimInfo",map);
	}
	public DimInfo findDimInfoById(Object dimId){
		Map map=new java.util.HashMap();
		map.put("dimId",dimId);
		return (DimInfo)dao.queryForObject("dimInfo.queryMapDimInfo",map);
	}


}