package nammi.login.dao;

import nammi.login.model.LoginInfo;
import java.util.List;
import java.util.Map;
import com.bill99.inf.ibatis.PageInfo;

public class LoginInfoDao extends com.bill99.inf.ibatis.BaseDao{
	public LoginInfo createLoginInfo(LoginInfo model){
		model.setId(super.getSequence("SEQ_LOGIN_INFO"));//如果主键是sequence生成
		dao.insert("loginInfo.insertLoginInfo",model);
		return model;
	}

	public void deleteLoginInfo(Object id){
		dao.delete("loginInfo.deleteLoginInfo",id);
	}

	public void updateLoginInfo(LoginInfo model){
		dao.update("loginInfo.updateLoginInfo",model);
	}

	public List<LoginInfo> queryLoginInfoByModel(LoginInfo model){
		return (List<LoginInfo>)dao.queryForList("loginInfo.queryModelLoginInfo",model);
	}

	public List<LoginInfo> queryLoginInfoByModelPage(LoginInfo model,PageInfo page){
		return (List<LoginInfo>)dao.queryForList("loginInfo.queryModelLoginInfo",model,page);
	}

	public List<LoginInfo> queryLoginInfoByMap(Map  map){
		return (List<LoginInfo>)dao.queryForList("loginInfo.queryMapLoginInfo",map);
	}

	public List<LoginInfo> queryLoginInfoByMapPage(Map  map,PageInfo page){
		return (List<LoginInfo>)dao.queryForList("loginInfo.queryMapLoginInfo",map,page);
	}

	public LoginInfo findLoginInfoByModel(LoginInfo model){
		return (LoginInfo)dao.queryForObject("loginInfo.queryModelLoginInfo",model);
	}
	public LoginInfo findLoginInfoByMap(Map  map){
		return (LoginInfo)dao.queryForObject("loginInfo.queryMapLoginInfo",map);
	}
	public LoginInfo findLoginInfoById(Object id){
		Map map=new java.util.HashMap();
		map.put("id",id);
		return (LoginInfo)dao.queryForObject("loginInfo.queryMapLoginInfo",map);
	}


}