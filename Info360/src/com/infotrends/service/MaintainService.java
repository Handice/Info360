package com.infotrends.service;

import java.util.ArrayList;
import java.util.List;

import com.infotrends.bean.CFG_person;
import com.infotrends.dao.CFG_personDao;
import com.infotrends.util.IsError;

/**
 * 維護相關業務功能
 * @author Lin
 */
public class MaintainService {
	/**
	 * 
	 * @param id
	 */
	public List<CFG_person> Query_Person(String employee_id){
		if(employee_id != null && !"".equals(employee_id.trim())){
			List<CFG_person> cfg_person = new ArrayList<CFG_person>();
			try{
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_person = cfg_personDao.Query_Person(employee_id);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_person;
		}
		return null;
	}
}
