package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;
@Path("/Query_PersonInfo")
public class Query_PersonInfoServlet {
	/**
	 * 使用POST方法
	 * 依據輸入DBID有無查詢個人帳號資訊或全體帳號資訊
	 * @param DBID
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("dbid")
								int dbid) throws IOException {

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		cfg_person.setDbid(dbid);
		jsonObject.put("status", Variable.POST_STATUS);
		
		try{
			MaintainService maintainService = new MaintainService();
	        List<CFG_person> cfg_personlist = maintainService.query_Person_DBID(cfg_person);
	        if(dbid != 0){
	        	//撈取cfg_group_person關聯
	        	CFG_group_person cfg_group_person = new CFG_group_person();
	        	cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
	        	List<CFG_group_person> cfg_person_grouplist = maintainService.query_Group_Person(cfg_group_person);
	        	JSONObject PersonGroupJsonObject = new JSONObject();
	        	JSONObject GroupJsonObject = new JSONObject();
		        for (int i = 0; i < cfg_person_grouplist.size(); i++) {
		        	PersonGroupJsonObject.accumulate("person_dbid", cfg_person_grouplist.get(i).getPerson_dbid());
		        	PersonGroupJsonObject.accumulate("group_dbid", cfg_person_grouplist.get(i).getGroup_dbid()); 
		        	
		        	//撈取cfg_group欄位
				    CFG_group cfg_group = new CFG_group();
				    cfg_group.setDbid(cfg_person_grouplist.get(i).getGroup_dbid());
				    List<CFG_group> cfg_grouplist = maintainService.query_Group(cfg_group);
				    GroupJsonObject.accumulate("dbid", cfg_grouplist.get(0).getDbid());
				    GroupJsonObject.accumulate("name", cfg_grouplist.get(0).getName()); 
				    GroupJsonObject.accumulate("state", cfg_grouplist.get(0).getState());
		        }		
		        jsonObject.put("person_group", PersonGroupJsonObject);
		        jsonObject.put("group", GroupJsonObject);
	        }
			
	        JSONObject PersonJsonObject = new JSONObject();
	        for (int i = 0; i < cfg_personlist.size(); i++) {
	        	PersonJsonObject.accumulate("dn", cfg_personlist.get(i).getDn());
	        	PersonJsonObject.accumulate("dbid", cfg_personlist.get(i).getDbid());
	        	PersonJsonObject.accumulate("createdatetime", cfg_personlist.get(i).getCreatedatetime());
	        	PersonJsonObject.accumulate("account",    cfg_personlist.get(i).getAccount());
	        	PersonJsonObject.accumulate("password", cfg_personlist.get(i).getPassword());
	        	PersonJsonObject.accumulate("first_name", cfg_personlist.get(i).getFirst_name());
	        	PersonJsonObject.accumulate("last_name",  cfg_personlist.get(i).getLast_name());
	        	PersonJsonObject.accumulate("user_name",  cfg_personlist.get(i).getUser_name());
	        	PersonJsonObject.accumulate("employee_id", cfg_personlist.get(i).getEmployee_id());
	        	PersonJsonObject.accumulate("emailaddress", cfg_personlist.get(i).getEmailaddress());
	        	PersonJsonObject.accumulate("state", cfg_personlist.get(i).getState());  
	        }		
	        jsonObject.put("person", PersonJsonObject);
	        	
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}
