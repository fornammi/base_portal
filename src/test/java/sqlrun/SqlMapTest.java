package sqlrun;

import com.bill99.inf.ibatis.DBFactory;
import com.bill99.inf.ibatis.SqlMapXMLGenerator;

public class SqlMapTest {

	public static void main(String[] args) throws Exception {
		DBFactory.driverClass = "oracle.jdbc.driver.OracleDriver";
		DBFactory.jdbcUrl = "jdbc:oracle:thin:@192.168.63.146:1530:billdb";
		DBFactory.userId = "rm";
		DBFactory.password = "rm";
		DBFactory.projectPath = "D:\\devTools\\myEcspace\\base-portal"; //项目路径
		DBFactory.charset = "UTF-8";
		DBFactory.isMySql=false;
		SqlMapXMLGenerator g = DBFactory.getSqlMapXMLGenerator();

		/**
		 * 
		 * @param tableName --表
		 * @param namespace --域名称
		 * @param modelPackageName --model对象的包名
		 * @param daoPackageName --dao对象的包名
		 * @param servicePackageName --service对象的包名
		 * @param className --model对象类名称，与表名称对应
		 * @param xmlFolder --生成的sqlmap文件的子目录
		 * @param seqName  --该表主键所使用的sequence名称
		 * @return
		 *   生成的文件有：
		 *   1、在src\main\resources\ormapping\ibatis下面生成sqlmap文件；
		 *   2、在指定的包下面生成model对象java文件；
		 *   3、在指定的包下面生成dao对象java文件；
		 *   4、在指定的包下面生成service对象java文件；
		 *   5、输出dao和servie对象的spring配置信息
		 */
		/*String xml = g.generateSql("login_info", "loginInfo",
				"nammi.login.model",
				"nammi.login.dao",
				"nammi.login.service", "LoginInfo", "login","SEQ_LOGIN_INFO");
		System.out.println(xml);*/
		
		/*String xml = g.generateSql("login_info", "loginInfo",
				"nammi.login.model",
				"nammi.login.dao",
				"nammi.login.service", "LoginInfo", "login","SEQ_LOGIN_INFO");
		System.out.println(xml);*/
		
		String xml1 = g.generateSql("T_BP_DIM", "dimInfo",
				"nammi.rule.engine.drools.model",
				"nammi.rule.engine.drools.dao",
				"nammi.rule.engine.drools.service", "DimInfo", "rule","");
		System.out.println(xml1);
		

		//seashell.seq_menuitem   seashell.seq_feature
	}

}
