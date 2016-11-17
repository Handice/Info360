package com.infotrends.service;

import java.util.ArrayList;
import java.util.List;

import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.dao.CFG_group_personDao;
import com.infotrends.dao.CFG_personDao;
import com.infotrends.util.IsError;

/**
 * 維護相關業務功能
 * 
 * @author Lin, Tim
 */
public class MaintainService {

	/**
	 * 新增註冊個人資料
	 * 
	 * @param cfg_person
	 */
	public int insert_PersonInfo(CFG_person cfg_person) {
		int count = 0;
		try {
			CFG_personDao cfg_personDao = new CFG_personDao();
			count = cfg_personDao.insert_PersonInfo(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}

	/**
	 * Select個人或全體資料的業務邏輯
	 * 
	 * @param cfg_person.account
	 */

	public List<CFG_person> query_Person(CFG_person cfg_person) {
		if (cfg_person.getAccount() != null && !"".equals(cfg_person.getAccount().trim())) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		 if (cfg_person.getAccount().trim() == null || "".equals(cfg_person.getAccount().trim())) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		return null;
	}

	/**
	 * Update個人資料的業務邏輯
	 * 
	 * @param cfg_person
	 */
	public int update_PersonInfo(CFG_person cfg_person) {

		int count = 0;
		try {
			CFG_personDao cfg_personDao = new CFG_personDao();
			count = cfg_personDao.update_PersonInfo(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}

	/**
	 * Delete 個人資料的業務邏輯
	 * 
	 * @param cfg_person
	 */

	public int delete_PersonInfo(CFG_person cfg_person) {

		int count = 0;
		try {
			CFG_personDao cfg_personDao = new CFG_personDao();
			count = cfg_personDao.delete(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	
	
	/**
	 * 新增個人所屬群組資料
	 * 
	 * @param CFG_group_person
	 */
	public int insert_PersonInfo(CFG_group_person cfg_group_person) {
		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.insert_Group_PersonInfo(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	
	/**
	 * Select個人群組獲所有群組資料的業務邏輯
	 * 
	 * @param CFG_group_person
	 */

	public List<CFG_group_person> query_Group_Person(CFG_group_person cfg_group_person) {
		if (cfg_group_person.getGroup_dpid()!=0) {
			List<CFG_group_person> cfg_group_personlist = new ArrayList<CFG_group_person>();
			try {
				CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
				cfg_group_personlist = cfg_group_personDao.query_Group_PersonInfo(cfg_group_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_group_personlist;
		}
		 if (cfg_group_person.getPerson_dpid()!=0) {
			List<CFG_group_person> cfg_group_personlist = new ArrayList<CFG_group_person>();
			try {
				CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
				cfg_group_personlist = cfg_group_personDao.query_Group_PersonInfo(cfg_group_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_group_personlist;
		}
		
		return null;

}
	/**
	 * Update個人群組資訊
	 * 
	 * @param CFG_group_person
	 */
	public int update_Group_PersonInfo(CFG_group_person cfg_group_person) {

		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.update_Group_PersonInfo(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Delete 個人資料群組資訊
	 * 
	 * @param CFG_group_person
	 */

	public int delete_Group_PersonInfo(CFG_group_person cfg_group_person) {

		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.delete(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
}
