package nammi.rule.engine.drools.service;

import nammi.rule.engine.drools.model.DimInfo;
import nammi.rule.engine.drools.dao.DimInfoDao;
import java.util.List;
import java.util.Map;
import com.bill99.inf.ibatis.PageInfo;


public class DimInfoService{
  private DimInfoDao dimInfoDao;

	public DimInfo createDimInfo(DimInfo model){
		return dimInfoDao.createDimInfo(model);
	}

	public void deleteDimInfo(Object id){
		dimInfoDao.deleteDimInfo(id);
	}

	public void updateDimInfo(DimInfo model){
		dimInfoDao.updateDimInfo(model);
	}

	public List<DimInfo> queryDimInfoByModel(DimInfo model){
		return dimInfoDao.queryDimInfoByModel(model);
	}

	public List<DimInfo> queryDimInfoByModelPage(DimInfo model,PageInfo page){
		return dimInfoDao.queryDimInfoByModelPage(model,page);
	}

	public List<DimInfo> queryDimInfoByMap(Map  map){
		return dimInfoDao.queryDimInfoByMap(map);
	}

	public List<DimInfo> queryDimInfoByMapPage(Map  map,PageInfo page){
		return dimInfoDao.queryDimInfoByMapPage(map,page);
	}

	public DimInfo findDimInfoByModel(DimInfo model){
		return dimInfoDao.findDimInfoByModel(model);
	}
	public DimInfo findDimInfoByMap(Map  map){
		return dimInfoDao.findDimInfoByMap(map);
	}
	public DimInfo findDimInfoById(Object dimId){
		return dimInfoDao.findDimInfoById(dimId);
	}
	public void setDimInfoDao(DimInfoDao dao){
		this.dimInfoDao=dao;
	}



}