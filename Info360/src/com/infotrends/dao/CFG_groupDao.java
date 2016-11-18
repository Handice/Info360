package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_person;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_groupDao {
	
	/**
	 * 查詢群組資訊
	 * DBID Query
	 * @param CFG_group
	 */
	public List<CFG_group> query_Group(CFG_group   cfg_group){
		DBAccess dbAccess = new DBAccess();
		List<CFG_group> cfg_groupList = new ArrayList<CFG_group>();
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_groupList = sqlSession.selectList("cfg_group.Query_GroupInfo", cfg_group);
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
		return cfg_groupList;
	}
	
	/**
<<<<<<< HEAD
	 * 查詢群組資訊
	 * DBID Query
	 * @param CFG_group
	 */
	public List<CFG_group> query_Group_name(CFG_group   cfg_group){
		DBAccess dbAccess = new DBAccess();
		List<CFG_group> cfg_groupList = new ArrayList<CFG_group>();
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_groupList = sqlSession.selectList("cfg_group.Query_GroupInfo_name", cfg_group);
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
		return cfg_groupList;
	}
	
	
	/**
=======
>>>>>>> branch 'backend' of https://github.com/Handice/Info360.git
	 * 新增註冊個人資訊
	 * @param CFG_person
	 */
	public int insert_GroupInfo(
			CFG_group   cfg_group)
			{
		DBAccess dbAccess = new DBAccess();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_personInt = sqlSession.insert("cfg_group.Insert_GroupInfo", cfg_group);
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
