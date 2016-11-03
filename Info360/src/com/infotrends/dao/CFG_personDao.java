package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_person;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_personDao {
	
	/**
	 * 根據查詢條件查詢消息列表
	 */
	public List<CFG_person> Query_Person(String employee_id){
		DBAccess dbAccess = new DBAccess();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		CFG_person cfg_person = new CFG_person();
		cfg_person.setEmployee_id(employee_id);
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Query_Person", cfg_person);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_personList;
	}
	
}
