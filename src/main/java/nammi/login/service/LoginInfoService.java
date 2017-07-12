package nammi.login.service;

import nammi.login.model.LoginInfo;
import nammi.login.dao.LoginInfoDao;
import java.util.List;
import java.util.Map;
import com.bill99.inf.ibatis.PageInfo;

public class LoginInfoService{
  private LoginInfoDao loginInfoDao;

	public LoginInfo createLoginInfo(LoginInfo model){
		return loginInfoDao.createLoginInfo(model);
	}

	public void deleteLoginInfo(Object id){
		loginInfoDao.deleteLoginInfo(id);
	}

	public void updateLoginInfo(LoginInfo model){
		loginInfoDao.updateLoginInfo(model);
	}

	public List<LoginInfo> queryLoginInfoByModel(LoginInfo model){
		return loginInfoDao.queryLoginInfoByModel(model);
	}

	public List<LoginInfo> queryLoginInfoByModelPage(LoginInfo model,PageInfo page){
		return loginInfoDao.queryLoginInfoByModelPage(model,page);
	}

	public List<LoginInfo> queryLoginInfoByMap(Map  map){
		return loginInfoDao.queryLoginInfoByMap(map);
	}

	public List<LoginInfo> queryLoginInfoByMapPage(Map  map,PageInfo page){
		return loginInfoDao.queryLoginInfoByMapPage(map,page);
	}

	public LoginInfo findLoginInfoByModel(LoginInfo model){
		return loginInfoDao.findLoginInfoByModel(model);
	}
	public LoginInfo findLoginInfoByMap(Map  map){
		return loginInfoDao.findLoginInfoByMap(map);
	}
	public LoginInfo findLoginInfoById(Object id){
		return loginInfoDao.findLoginInfoById(id);
	}
	public void setLoginInfoDao(LoginInfoDao dao){
		this.loginInfoDao=dao;
	}



}