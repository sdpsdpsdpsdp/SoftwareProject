package com.laison.softwareproject;

import com.laison.softwareproject.common.utils.CodeGenUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.collections4.map.HashedMap;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.Map;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GeneratorBean {

	
	DataSource dataSource;

	
	@Before
	public void before_bean() throws Exception {
		HikariConfig configuration =new HikariConfig();
		configuration.setJdbcUrl("jdbc:mysql://192.168.3.47:3306/soft_examin?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false");
		configuration.setUsername("root");
		configuration.setPassword("laison!@#");
		dataSource=new HikariDataSource(configuration );
	}
	@Test
	public void generatorAll() throws Exception {
		String entityPackageName = "com.laison.softwareproject.model.sys";
		String daoPackageName = "com.laison.softwareproject.dao.sys";
		String servicePackageName = "com.laison.softwareproject.service.sys";
//		String controllerPackageName = "com.laison.softwareproject.controller.sys";
		String controllerPackageName = "";
		String queryTimeFiled="createTime";//createTime
		String tableName = "sys_sms_template";
		CodeGenUtil.generatorAll(tableName, queryTimeFiled,entityPackageName, daoPackageName, servicePackageName,controllerPackageName, dataSource);
		
	} 
	@Test
	public void simpalTest() throws Exception {
		String replaceAll = "com.laison.nlapis.controller.sys".replaceAll("\\.", "/");
		System.out.println(replaceAll);
	} 
	
	@Test
	public void generatorHtml() throws Exception {
		//String dir = "C:\\Users\\Administrator\\Desktop\\temp_code\\sys_user";
		String dir = "d:\\stock_db\\aa";
		String tableName = "erp_calendar_task";
		String nameFiled="";//名字字段 用于树形
		Map<String, Boolean> queryField=new HashedMap<>();
		//queryField.put("name", true);
		
//		queryField.put("configName", true);
//		queryField.put("configName", true);

		//queryField.put("state", true);
		String orderBy="update_time desc";
		boolean isTree = false; //最重要
		CodeGenUtil.generatorHtml(tableName, dir, queryField, orderBy, dataSource,isTree,nameFiled);
	} 
	@Test
	public void generatorEntity() throws Exception {
		String packageName = "com.laison.nlapis.model.scheme";
		String tableName = "meter_type";
		CodeGenUtil.generatorEntity(tableName, packageName, dataSource);
	} 
	@Test
	public void generatorDao() throws Exception {
		String repositoryPackageName = "com.laison.nlapis.dao.biz";
		String keyType="Long";
		String entityPackageName="com.laison.nlapis.model.biz";
		String entityName="SunpendRecordView";
		CodeGenUtil.generatorDao(repositoryPackageName, entityPackageName, entityName, keyType);
	} 
	@Test
	public void generatorService() throws Exception {
		String repositoryPackageName = "com.lihua.repository.sys";
		String servicePackageName = "com.lihua.service.sys";
		String keyType="String";
		String entityPackageName="com.lihua.entity.sys";
		String entityName="SysDept";
		String keyName="deptId";
		//CodeGenUtil.generatorService(servicePackageName,repositoryPackageName, entityPackageName, entityName, keyType,keyName);
	} 
	
	@Test
	public void generatorController() throws Exception {
		String controllerPackageName = "com.laison.nlapis.controller.sys";
		String servicePackageName = "com.laison.nlapis.service.sys";
		String entityPackageName="com.laison.nlapis.model.sys";
		String entityName="SysRole";
		//CodeGenUtil.generatorController(controllerPackageName,servicePackageName, entityPackageName, entityName,"Long");
		
	} 
	
}
