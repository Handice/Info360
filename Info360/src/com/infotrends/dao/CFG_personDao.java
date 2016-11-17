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
	 * 新增註冊個人資訊
	 * @param CFG_person
	 */
	public int insert_PersonInfo(
			CFG_person   cfg_person)
			{
		DBAccess dbAccess = new DBAccess();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_personInt = sqlSession.insert("cfg_person.Insert_PersonInfo", cfg_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_personInt;
	}
	
	/**
	 * 查詢個人資訊或所有資訊
	 * @param CFG_person
	 */
	
	
	public List<CFG_person> query_Person(CFG_person   cfg_person){
		DBAccess dbAccess = new DBAccess();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Query_PersonInfo", cfg_person);
			sqlSession.commit();
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
	
	/**
	 * 更新個人資訊
	 * @param CFG_person
	 */
	
	public int update_PersonInfo(
			CFG_person   cfg_person	){
		DBAccess dbAccess = new DBAccess();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.insert("cfg_person.Update_PersonInfo", cfg_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_personInt;
	}
	
	/**
	 * 刪除個人資訊
	 * @param CFG_person
	 */
	
	public int delete(CFG_person   cfg_person){
		DBAccess dbAccess = new DBAccess();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.delete("cfg_person.Delete_PersonInfo", cfg_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_personInt;
	}
	
	
}
